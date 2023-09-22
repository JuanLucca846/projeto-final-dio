package com.user.service.impl;

import com.user.dto.UsersDto;
import com.user.entity.Users;
import com.user.exception.UserNotFoundException;
import com.user.mapper.UserMapper;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UsersDto createUser(UsersDto usersDto){
        Users newUser = userMapper.toEntity(usersDto);

        Users savedUser = userRepository.save(newUser);

        return userMapper.toDto(savedUser);
    }

    public UsersDto updateUser(Long id, UsersDto usersDto){
        Optional<Users> optionalUsers = userRepository.findById(id);
        if(optionalUsers.isPresent()){
            Users user = optionalUsers.get();

            user.setFirstName(usersDto.getFirstName());
            user.setLastName(usersDto.getLastName());
            user.setEmail(usersDto.getEmail());

            user = userRepository.save(user);
            return userMapper.toDto(user);
        }else {
            throw new UserNotFoundException(id);
        }
    }

    public void deleteUser(Long id){
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userRepository.deleteById(id);
    }

    public UsersDto getUserById(Long id){
        Users getUserById = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return userMapper.toDto(getUserById);
    }

    public List<UsersDto> getAllUsers(){
        List<Users> users = userRepository.findAll();
        return userMapper.toDtoList(users);
    }

}
