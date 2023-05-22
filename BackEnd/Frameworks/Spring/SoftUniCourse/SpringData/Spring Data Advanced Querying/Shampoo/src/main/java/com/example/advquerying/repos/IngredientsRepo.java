package com.example.advquerying.repos;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientsRepo  extends JpaRepository<Ingredient , Long> {
    List<Ingredient> findAllByNameStartingWith(String name);
    List<Ingredient> findAllByNameInOrderByPrice(List<String> names);

    void deleteByName(String name);


}
