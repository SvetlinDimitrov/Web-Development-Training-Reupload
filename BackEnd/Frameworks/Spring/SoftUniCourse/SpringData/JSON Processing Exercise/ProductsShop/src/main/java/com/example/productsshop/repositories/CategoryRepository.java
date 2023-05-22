package com.example.productsshop.repositories;

import com.example.productsshop.entities.products.Category;
import com.example.productsshop.entities.Dtos.Json.CategorySummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select new com.example.productsshop.entities.Dtos.Json.CategorySummary(c.name , count(p.id) , avg (p.price),sum(p.price)) " +
            "from Product p join p.categories c " +
            "group by c.name " +
            "order by count(p.id)")
    Optional<List<CategorySummary>> categorySummary();
}
