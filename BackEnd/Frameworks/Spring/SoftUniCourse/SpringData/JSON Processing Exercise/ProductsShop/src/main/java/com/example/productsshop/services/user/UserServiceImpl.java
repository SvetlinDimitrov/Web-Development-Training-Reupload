package com.example.productsshop.services.user;

import com.example.productsshop.entities.users.User;
import com.example.productsshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override

    public List<User> SuccessfullySoldProducts() {
        return userRepository.findAllBySoldProductsBuyerIsNotNull();
    }

    @Override
    public List<User> findAllBySoldProductsBuyerIsNotNullOrderByLastName() {
        return userRepository.findAllBySoldProductsBuyerIsNotNullOrderByLastName();
    }
}
