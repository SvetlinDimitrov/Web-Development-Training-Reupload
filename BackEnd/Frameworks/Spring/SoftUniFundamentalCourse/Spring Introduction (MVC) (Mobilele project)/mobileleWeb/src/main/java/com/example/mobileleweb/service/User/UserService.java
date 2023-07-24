package com.example.mobileleweb.service.User;

import com.example.mobileleweb.domain.entity.User;
import com.example.mobileleweb.domain.viewDtos.LoggedUser;
import com.example.mobileleweb.domain.viewDtos.RegisterUserDto;

public interface UserService {
    void register(RegisterUserDto registerUserDto);

    boolean checkIfUsernameAlreadyExists(String username);

    User getUserByUsername(String username);

    User findById(String sellerId);
}
