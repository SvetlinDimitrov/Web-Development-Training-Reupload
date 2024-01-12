package com.example.advquerying.repos;

import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepo extends JpaRepository<Shampoo , Long> {
    List<Shampoo> findAllBySizeOrderById(Size size);
    List<Shampoo> findAllBySizeOrLabel_IdOrderByPriceAsc(Size size , long label);
    @Query("select s from Shampoo s Where s.price > :price order by s.price desc ")
    List<Shampoo> findAllByPriceOrderByPriceDesc(@Param(value = "price")BigDecimal price);
    Integer countAllByPriceLessThan (BigDecimal price);
    @Query("select s from Shampoo s join s.ingredients i where i.name in (:names)")
    Set<Shampoo> findAllByIngredientsName(@Param(value = "names")List<String> names);

    @Query("select s from Shampoo s where s.ingredients.size < (:count)")
    List<Shampoo> findAllByIngredientsCount(@Param(value = "count") int count);

}
