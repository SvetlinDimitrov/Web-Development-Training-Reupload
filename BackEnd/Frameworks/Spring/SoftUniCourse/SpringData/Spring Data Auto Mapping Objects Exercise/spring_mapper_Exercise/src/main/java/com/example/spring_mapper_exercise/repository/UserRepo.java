package com.example.spring_mapper_exercise.repository;

import com.example.spring_mapper_exercise.domain.entities.Order;
import com.example.spring_mapper_exercise.domain.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User , Long> {
    User findByEmail(String email);
    @Transactional
    @Modifying
    @Query("update User u set u.order = :orders where u.email = :email")
    void updateByEmail(String email , List<Order> orders);
}
