package com.plannerapp.service;
import com.plannerapp.model.dtos.UserView;
import com.plannerapp.model.dtos.UserLogged;
import com.plannerapp.model.dtos.UserLoginDto;
import com.plannerapp.model.dtos.UserRegisterDto;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void registerUser(UserRegisterDto userRegisterDto) {
        userRepository.save(toUser(userRegisterDto));
    }

    private User toUser (UserRegisterDto userRegisterDto){
        User user  = new User();
        user.setEmail(userRegisterDto.getEmail());
        user.setUsername(userRegisterDto.getUsername());
        user.setPassword(userRegisterDto.getPassword());
        return user;
    }

    public boolean login(UserLoginDto userLoginDto, BindingResult result) {
        Optional<User> user = userRepository.findByUsername(userLoginDto.getUsername());
        if(user.isPresent() && user.get().getPassword().equals(userLoginDto.getPassword())){
            return true;
        }
        result.addError(new FieldError("loginDto" , "password" , "username or password is wrong"));
        return false;
    }

    @Transactional
    public UserView getViewUser(UserLogged user) {
        return userRepository.findByUsername(user.getUsername())
                .map(UserView::new)
                .orElseThrow(() -> new RuntimeException("no user found with that username :" + user.getUsername()));
    }
}
