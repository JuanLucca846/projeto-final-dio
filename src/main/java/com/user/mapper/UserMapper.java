package com.user.mapper;


import com.user.dto.UsersDto;
import com.user.entity.Users;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UsersDto toDto(Users users);

    Users toEntity(UsersDto usersDto);

    List<UsersDto> toDtoList(List<Users> usersList);
}
