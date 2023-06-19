package com.example.mobileleweb.service.User;

import com.example.mobileleweb.domain.modelViewEntity.UserView;
import com.example.mobileleweb.domain.viewDtos.LoggedUser;
import com.example.mobileleweb.domain.viewDtos.LoginUserDto;
import com.example.mobileleweb.domain.viewDtos.RegisterUserDto;

public interface UserService {
    void register(RegisterUserDto registerUserDto);

    boolean login(LoginUserDto loginUserDto);


    boolean checkIfUsernameAlreadyExists(String username);

    LoggedUser getLoggedUser(LoginUserDto loginUserDto);
}
