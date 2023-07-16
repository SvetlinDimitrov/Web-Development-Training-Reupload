package com.example.productsshop.repositories;

import com.example.productsshop.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllBySoldProductsBuyerIsNotNull();
    List<User> findAllBySoldProductsBuyerIsNotNullOrderByLastName();
}
