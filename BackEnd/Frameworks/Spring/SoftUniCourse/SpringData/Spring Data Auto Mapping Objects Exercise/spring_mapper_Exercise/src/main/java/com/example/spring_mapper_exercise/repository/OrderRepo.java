package com.example.spring_mapper_exercise.repository;

import com.example.spring_mapper_exercise.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order , Long> {

}
