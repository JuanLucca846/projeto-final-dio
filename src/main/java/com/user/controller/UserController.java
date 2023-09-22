package com.user.controller;


import com.user.dto.UsersDto;
import com.user.entity.Users;
import com.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<UsersDto> createUser(@Valid @RequestBody UsersDto usersDto){
        try{
            UsersDto createdUser = userService.createUser(usersDto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(createdUser.getEmail()).toUri();
            return ResponseEntity.created(location).body(createdUser);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Can not create a user!", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDto> updateUser(@PathVariable Long id, @RequestBody UsersDto usersDto){
        UsersDto updatedUser = userService.updateUser(id, usersDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDto> getUser(@PathVariable Long id){
        UsersDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UsersDto>> getAllUsers(){
        List<UsersDto> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
}
