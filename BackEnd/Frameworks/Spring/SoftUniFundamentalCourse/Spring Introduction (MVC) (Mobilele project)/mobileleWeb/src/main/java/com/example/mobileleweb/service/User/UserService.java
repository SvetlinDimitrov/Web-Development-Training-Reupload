package com.example.mobileleweb.service.User;

import com.example.mobileleweb.domain.entity.UserEntity;
import com.example.mobileleweb.domain.viewDtos.RegisterUserDto;

public interface UserService {
    void register(RegisterUserDto registerUserDto);

    boolean checkIfUsernameAlreadyExists(String username);

    UserEntity getUserByUsername(String username);

    UserEntity findById(String sellerId);
}
