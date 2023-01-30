package com.BlogApp.services;


import com.BlogApp.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getuserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);




}
