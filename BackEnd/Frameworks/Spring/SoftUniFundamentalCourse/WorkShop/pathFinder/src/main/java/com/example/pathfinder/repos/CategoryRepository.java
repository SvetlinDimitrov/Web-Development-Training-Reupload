package com.example.pathfinder.repos;

import com.example.pathfinder.domain.constants.CategoryConstant;
import com.example.pathfinder.domain.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Categorie, Long> {
    Optional<Categorie> findByName(CategoryConstant name);
}

