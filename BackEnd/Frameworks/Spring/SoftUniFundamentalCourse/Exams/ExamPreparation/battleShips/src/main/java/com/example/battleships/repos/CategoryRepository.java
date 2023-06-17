package com.example.battleships.repos;

import com.example.battleships.domain.constants.CategoryConstants;
import com.example.battleships.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(CategoryConstants name);
}
