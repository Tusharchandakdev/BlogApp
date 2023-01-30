package com.BlogApp.services.impl;

import com.BlogApp.entities.User;
import com.BlogApp.payloads.UserDto;
import com.BlogApp.repositories.UserRepo;
import com.BlogApp.services.UserService;
import com.BlogApp.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.dtoToUser(userDto);

        User saveduser = this.userRepo.save(user);

        return this.usertoDto(saveduser);




    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

         User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","ID",userId));
         user.setName(userDto.getName());
         user.setEmail(userDto.getEmail());
         user.setAbout(userDto.getAbout());

         User updatedUser = this.userRepo.save(user);

          UserDto userDto1=  this.usertoDto(updatedUser);
          return userDto1;



    }

    @Override
    public UserDto getuserById(Integer userId) {
      User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","ID",userId));
      return this.usertoDto(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.usertoDto(user)).collect(Collectors.toList());
        return userDtos;

    }

    @Override
    public void deleteUser(Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","ID",userId));
        this.userRepo.delete(user);

    }

    public User dtoToUser(UserDto userDto)
    {
        User user = this.modelMapper.map(userDto,User.class);
        //User user = new User();
       // user.setId(userDto.getId());
        //user.setAbout(userDto.getAbout());
       // user.setName(userDto.getName());
       // user.setEmail(userDto.getEmail());
        //user.setPassword(userDto.getPassword());
        return user;


    }

    public UserDto usertoDto(User user)
    {

        UserDto userDto = this.modelMapper.map(user,UserDto.class);
        //UserDto userDto = new UserDto();
       // userDto.setAbout(user.getAbout());
        //userDto.setEmail(user.getEmail());
        //userDto.setId(user.getId());
        ///userDto.setName(user.getName());
        //userDto.setPassword(user.getPassword());
        return userDto;


    }
}
