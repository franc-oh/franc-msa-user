package com.franc.domain.user.service;

import com.franc.domain.user.domain.User;
import com.franc.domain.user.dto.UserGetAllDto;
import com.franc.domain.user.dto.UserGetDto;
import com.franc.domain.user.dto.UserSaveDto;
import com.franc.domain.user.mapper.UserMapper;
import com.franc.global.error.ErrorCode;
import com.franc.global.util.FrancUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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

    private final UserMapper userMapper;


    /**
     * 회원가입
     * @param request
     * @return
     * @throws Exception
     */
    public UserSaveDto.Response saveUser(UserSaveDto.Request request) throws Exception {
        User user = userService.saveUser(userMapper.toEntity(request));
        return userMapper.toSaveDto(user);
    }


    /**
     * 회원 전체조회
     * @return
     * @throws Exception
     */
    public UserGetAllDto.Response getAllUser() throws Exception {
        List<User> users = userService.findAllUser();

        if(Objects.isNull(users) || users.isEmpty()) {
            return new UserGetAllDto.Response(new ArrayList<>());
        }

        return new UserGetAllDto.Response(userMapper.toGetAllDto(users));
    }

    /**
     * 회원조회 - userId
     * @param userId
     * @return
     * @throws Exception
     */
    public UserGetDto.Response getUser(String userId) throws Exception {
        User user = FrancUtil.isNullThrowBizException(userService.findUserByUserId(userId), ErrorCode.USER_NOT_EXISTS);
        return userMapper.toGetDto(user);
    }




}
