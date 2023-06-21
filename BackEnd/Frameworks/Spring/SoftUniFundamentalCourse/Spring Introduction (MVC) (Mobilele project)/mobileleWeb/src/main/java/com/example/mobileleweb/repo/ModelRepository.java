package com.example.mobileleweb.repo;

import com.example.mobileleweb.domain.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
    @Query("select m from Model m order by RAND() limit 1")
    Model getRandomModel();
}
