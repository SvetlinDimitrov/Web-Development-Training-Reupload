package com.example.mobilelegraderebuild.service.User;

import com.example.mobilelegraderebuild.domain.entity.UserEntity;
import com.example.mobilelegraderebuild.domain.viewDtos.RegisterUserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {
    void register(RegisterUserDto registerUserDto , HttpServletRequest request , HttpServletResponse response);

    boolean checkIfUsernameAlreadyExists(String username);

    UserEntity getUserByUsername(String username);

    UserEntity findById(String sellerId);
}
