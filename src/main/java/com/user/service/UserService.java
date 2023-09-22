package com.user.service;

import com.user.dto.UsersDto;

import java.util.List;

public interface UserService {

    UsersDto createUser(UsersDto usersDto);

    UsersDto updateUser(Long id, UsersDto usersDto);

    void deleteUser(Long id);

    UsersDto getUserById(Long id);

    List<UsersDto> getAllUsers();
}
