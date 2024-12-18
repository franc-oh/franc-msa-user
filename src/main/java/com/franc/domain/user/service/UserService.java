package com.franc.domain.user.service;

import com.franc.domain.user.domain.User;
import com.franc.domain.user.repository.UserRepository;
import com.franc.global.error.ErrorCode;
import com.franc.global.util.FrancUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * [회원] Service (Controller > Facade > Service > Repository)
 * - 해당 도메인의 개별 기능구현
 *      - 쿼리호출
 *      - 데이터 가공
 *      - 재사용
 */

@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public User findUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }


    public User saveUser(User user) throws Exception {
        // 가입 전 동일 이메일로 가입했는지 체크
        FrancUtil.isNotNullThrowBizException(findUserByEmail(user.getEmail()), ErrorCode.USER_EXISTS_EMAIL);

        // userId 채번 후 회원가입
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }
}
