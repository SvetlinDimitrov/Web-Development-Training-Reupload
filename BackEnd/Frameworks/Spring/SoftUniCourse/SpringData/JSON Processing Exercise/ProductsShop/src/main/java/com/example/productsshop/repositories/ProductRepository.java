package com.example.productsshop.repositories;

import com.example.productsshop.entities.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {
    List<Product> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal price1 , BigDecimal price2);

}

