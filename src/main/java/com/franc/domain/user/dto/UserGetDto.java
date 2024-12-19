package com.franc.domain.user.dto;

/**
 * 회원조회 DTO
 */
public record UserGetDto() {

    /**
     * 응답
     * @param name
     * @param email
     * @param userId
     */
    public record Response(
            String name,
            String email,
            String userId
    ) {

    }
}
