package com.example.productsshop.services;

import com.example.productsshop.entities.users.User;

import java.util.List;

public interface UserService {
    List<User> SuccessfullySoldProducts();
    List<User> findAllBySoldProductsBuyerIsNotNullOrderByLastName();
}
