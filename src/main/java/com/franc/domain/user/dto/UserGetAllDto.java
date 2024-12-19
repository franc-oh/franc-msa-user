package com.franc.domain.user.dto;

import java.util.List;

/**
 * 회원 전체조회 DTO
 */
public record UserGetAllDto() {

    /**
     * 응답
     * @param users
     */
    public record Response(
            List<UserInfo> users
    ) {

        /**
         * Nested Object
         * @param name
         * @param email
         * @param userId
         */
        public record UserInfo(
                String name,
                String email,
                String userId
        ) {

        }
    }
}
