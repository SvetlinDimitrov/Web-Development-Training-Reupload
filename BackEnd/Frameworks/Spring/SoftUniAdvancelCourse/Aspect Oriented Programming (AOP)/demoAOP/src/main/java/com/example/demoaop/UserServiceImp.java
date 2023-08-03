package com.example.demoaop;

import com.example.demoaop.entity.User;
import com.example.demoaop.repo.UserRepository;
import org.springframework.stereotype.Component;

import javax.naming.NotContextException;
import java.util.List;

@Component
public class UserServiceImp {

    private final UserRepository repo;

    public UserServiceImp(UserRepository repo) {
        this.repo = repo;
    }


    public void login(User user){
        System.out.println("Logging user " + user.getName());
    }

    public User registerUser(User user){
        return user;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }


}
