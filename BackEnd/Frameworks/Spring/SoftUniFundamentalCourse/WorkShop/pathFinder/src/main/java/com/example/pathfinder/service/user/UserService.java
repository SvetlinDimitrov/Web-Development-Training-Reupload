package com.example.pathfinder.service.user;

import com.example.pathfinder.domain.bindingViews.ViewUser;
import com.example.pathfinder.domain.dtos.LoginUserDto;
import com.example.pathfinder.domain.dtos.RegisterUserDto;

public interface UserService {
    boolean register(RegisterUserDto registerUserDto);

    ViewUser login(LoginUserDto loginUserDto);
}
