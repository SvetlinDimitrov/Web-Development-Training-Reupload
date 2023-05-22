package com.example.productsshop.entities.Dtos.Json;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDtoSoldResponse {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private List<ProductDtoSellerAndBuyer> soldProducts;
}
