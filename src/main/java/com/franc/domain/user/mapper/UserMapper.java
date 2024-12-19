package com.franc.domain.user.mapper;

import com.franc.domain.user.domain.User;
import com.franc.domain.user.dto.UserGetAllDto;
import com.franc.domain.user.dto.UserGetDto;
import com.franc.domain.user.dto.UserSaveDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toEntity(UserSaveDto.Request dto);
    UserSaveDto.Response toSaveDto(User entity);

    UserGetDto.Response toGetDto(User entity);

    List<UserGetAllDto.Response.UserInfo> toGetAllDto(List<User> entities);


}
