package com.franc.domain.user.controller;

import com.franc.domain.user.dto.UserGetAllDto;
import com.franc.domain.user.dto.UserGetDto;
import com.franc.domain.user.dto.UserSaveDto;
import com.franc.domain.user.service.UserFacade;
import com.franc.global.common.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    /**
     * 회원 전체조회
     * @return
     * @throws Exception
     */
    @GetMapping
    public ApiResponse<?> getAll() throws Exception {
        UserGetAllDto.Response response = userFacade.getAllUser();
        return ApiResponse.ok(response);
    }

    /**
     * 회원조회 - userId
     * @param userId
     * @return
     * @throws Exception
     */
    @GetMapping("/{userId}")
    public ApiResponse<?> get(@PathVariable("userId") @NotBlank String userId) throws Exception {
        UserGetDto.Response response = userFacade.getUser(userId);
        return ApiResponse.ok(response);
    }



    @GetMapping("/health_check")
    public ApiResponse<?> status(HttpServletRequest request) throws Exception {
        return ApiResponse.ok("User Service Ok! - port="+request.getServerPort());
    }
}
