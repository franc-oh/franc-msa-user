package com.franc.domain.user.service;

import com.franc.domain.user.domain.User;
import com.franc.domain.user.dto.UserSaveDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * [회원] Facade (Controller > Facade > Service > Repository)
 *  - 하나의 엔드포인트에 대한 비즈니스로직을 담당
 *      - Service의 개별 기능들을 조립 > 비즈니스 로직을 구현
 *      - Transaction 설정
 */

@Component
@RequiredArgsConstructor
public class UserFacade {
    private static final Logger logger = LoggerFactory.getLogger(UserFacade.class);

    private final UserService userService;


    /**
     * 회원가입
     * @param request
     * @return
     * @throws Exception
     */
    public UserSaveDto.Response saveUser(UserSaveDto.Request request) throws Exception {

        User user = userService.saveUser(UserSaveDto.Request.toEntity(request));

        return UserSaveDto.Response.fromEntity(user);
    }




}
