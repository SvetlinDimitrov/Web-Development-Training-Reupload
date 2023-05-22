package com.example.springintro.services;

import com.example.springintro.models.User;
import com.example.springintro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public void register(User user) {
        Optional<User> user1 = userRepository.findByUsername(user.getUsername());
        boolean present = user1.isPresent();
        if(present){
            throw new RuntimeException("tuka e");
        }
        userRepository.save(user);
    }
}
