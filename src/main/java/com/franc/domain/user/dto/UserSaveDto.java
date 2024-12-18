package com.franc.domain.user.dto;

import com.franc.domain.user.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

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

        // DTO -> VO
        public static User toEntity(UserSaveDto.Request dto) {
            return User.builder()
                    .email(dto.email())
                    .name(dto.name())
                    .pwd(dto.pwd)
                    .build();
        }
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

        // VO -> DTO
        public static UserSaveDto.Response fromEntity(User user) {
            if(Objects.isNull(user) || Objects.isNull(user.getEmail())) return null;

            return new UserSaveDto.Response(
                    user.getEmail(),
                    user.getName(),
                    user.getUserId()
            );
        }
    }
}
