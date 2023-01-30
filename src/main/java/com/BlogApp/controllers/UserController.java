package com.BlogApp.controllers;

import com.BlogApp.payloads.UserDto;
import com.BlogApp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser( @Valid @RequestBody UserDto userDto)
    {
        UserDto createdUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.OK);

    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid){


       UserDto updateduser =  this.userService.updateUser(userDto,uid);
       return ResponseEntity.ok(updateduser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid)
    {
        this.deleteUser(uid);
        return ResponseEntity.ok(Map.of("message","user deleted succesfully"));

    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers()
    {

        return ResponseEntity.ok(this.userService.getAllUsers());




    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer userId)
    {
        UserDto user =  this.userService.getuserById(userId);
        return ResponseEntity.ok(user);

    }







}
