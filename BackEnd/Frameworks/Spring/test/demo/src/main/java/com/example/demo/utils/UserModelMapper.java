package com.example.demo.utils;

import com.example.demo.model.dto.CreateUser;
import com.example.demo.model.dto.UserView;
import com.example.demo.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapper {
    public User toUser(CreateUser createUser){
        User user = new User();
        user.setName(createUser.name());
        user.setPassword(createUser.password());
        return user;
    }
    public UserView toUserView(User user){
        return new UserView(user.getId().toString() , user.getName() , user.getPassword(), user.getDate());
    }
}
