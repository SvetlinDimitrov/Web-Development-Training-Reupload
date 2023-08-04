package com.example.pathfinder.service.user;

import com.example.pathfinder.domain.bindingViews.ViewUser;
import com.example.pathfinder.domain.dtos.LoginUserDto;
import com.example.pathfinder.domain.dtos.RegisterUserDto;
import com.example.pathfinder.domain.entity.UserEntity;

public interface UserService {
    void register(RegisterUserDto registerUserDto);


    boolean checkTheEmail(String value);

    boolean checkTheUsername(String value);


    ViewUser getViewUserById(Long id);

    UserEntity findById(Long id);

    LoginUserDto findByUsername(String username);
}
