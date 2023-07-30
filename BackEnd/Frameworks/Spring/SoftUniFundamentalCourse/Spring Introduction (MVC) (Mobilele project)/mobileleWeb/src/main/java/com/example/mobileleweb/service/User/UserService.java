package com.example.mobileleweb.service.User;

import com.example.mobileleweb.domain.entity.UserEntity;
import com.example.mobileleweb.domain.viewDtos.RegisterUserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {
    void register(RegisterUserDto registerUserDto , HttpServletRequest request , HttpServletResponse response);

    boolean checkIfUsernameAlreadyExists(String username);

    UserEntity getUserByUsername(String username);

    UserEntity findById(String sellerId);
}
