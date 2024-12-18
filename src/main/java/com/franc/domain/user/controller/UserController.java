package com.franc.domain.user.controller;

import com.franc.domain.user.dto.UserSaveDto;
import com.franc.domain.user.service.UserFacade;
import com.franc.global.common.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * [회원] Controller (Controller > Facade > Service > Dao)
 */

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserFacade userFacade;

    /**
     * 회원가입
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping
    public ApiResponse<?> save(@RequestBody @Valid UserSaveDto.Request request) throws Exception {
        UserSaveDto.Response response = userFacade.saveUser(request);
        return ApiResponse.ok(response);

    }


    @GetMapping("/health_check")
    public ApiResponse<?> status() throws Exception {
        return ApiResponse.ok("User Service Ok!");
    }
}
