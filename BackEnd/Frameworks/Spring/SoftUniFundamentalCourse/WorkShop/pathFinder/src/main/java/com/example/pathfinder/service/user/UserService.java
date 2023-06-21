package com.example.pathfinder.service.user;

import com.example.pathfinder.domain.bindingViews.ViewUser;
import com.example.pathfinder.domain.dtos.LoginUserDto;
import com.example.pathfinder.domain.dtos.RegisterUserDto;
import com.example.pathfinder.domain.entity.User;

public interface UserService {
    boolean register(RegisterUserDto registerUserDto);

    ViewUser login(LoginUserDto loginUserDto);

    boolean checkTheEmail(String value);

    boolean checkTheUsername(String value);


    ViewUser getViewUserById(Long id);

    User findById(Long id);
}
