package com.example.cardriver.repos;

import com.example.cardriver.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
    @Query("SELECT p FROM Part p order by RAND() limit 5")
    List<Part> getRandomParts();
}
