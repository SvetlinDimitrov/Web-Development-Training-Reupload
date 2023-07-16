package com.example.productsshop.entities.Dtos.Json;

import com.example.productsshop.entities.users.User;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private User seller;

}
