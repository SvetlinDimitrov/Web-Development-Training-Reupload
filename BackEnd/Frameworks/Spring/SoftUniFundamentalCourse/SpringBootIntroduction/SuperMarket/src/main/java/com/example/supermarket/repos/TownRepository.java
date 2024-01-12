package com.example.supermarket.repos;

import com.example.supermarket.domain.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town, String> {
    Town findByName(String name);
}
