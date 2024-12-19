package com.franc.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 회원가입 DTO
 */
public record UserSaveDto() {

    /**
     * 요청
     * @param email
     * @param name
     * @param pwd
     */
    public record Request(
            @NotBlank
            @Email
            String email,

            @NotBlank
            @Size(min = 5)
            String name,

            @NotBlank
            @Size(min = 4)
            String pwd
    ) {

    }


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
