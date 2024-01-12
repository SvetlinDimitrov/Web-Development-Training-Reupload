package com.example.spring_mapper_exercise.service;

import com.example.spring_mapper_exercise.domain.DTOs.UserLoginDto;
import com.example.spring_mapper_exercise.domain.DTOs.UserRegisterDto;
import org.modelmapper.ModelMapper;

public interface UserService {
    void RegisterUser (UserRegisterDto userRegisterDto);

    void LoginUser (UserLoginDto userLoginDto);

    void Logout ();
    void OwnedGames();

    void AddItem(String titleGame);

    void RemoveItem(String titleGame);

    void BuyItem();
}
