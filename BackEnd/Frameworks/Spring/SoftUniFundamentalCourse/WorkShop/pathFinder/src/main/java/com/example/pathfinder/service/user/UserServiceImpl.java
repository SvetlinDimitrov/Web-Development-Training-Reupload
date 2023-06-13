package com.example.pathfinder.service.user;

import com.example.pathfinder.domain.dtos.LoggedUserDto;
import com.example.pathfinder.domain.dtos.LoginUserDto;
import com.example.pathfinder.domain.dtos.RegisterUserDto;
import com.example.pathfinder.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private LoggedUserDto loggedUser;

    @Override
    public boolean register(RegisterUserDto registerUserDto) {
        //TODO check if the user abv is in the database
        //TODO save the user if its not
        //TODO set the role of user only
        return false;
    }

    @Override
    public boolean login(LoginUserDto loginUserDto){
        //TODO check if the user is in the database
        //TODO logged the user setting loggedUser

        return false;
    }

    public void logout(){
        loggedUser
                .setId(null)
                .setRoles(null);
    }
}
