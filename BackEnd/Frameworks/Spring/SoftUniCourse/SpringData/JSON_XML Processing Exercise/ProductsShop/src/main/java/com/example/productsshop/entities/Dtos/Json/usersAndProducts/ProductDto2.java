package com.example.productsshop.entities.Dtos.Json.usersAndProducts;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter


public class ProductDto2 {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    public ProductDto2() {
    }

    public ProductDto2(String name, BigDecimal price) {
        this();
        this.name = name;
        this.price = price;
    }
}
