package com.example.productsshop.entities.Dtos.Json.usersAndProducts;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoldProductCollectionDto {
    @Expose
    private Integer count;
    @Expose
    private List<ProductDto2> productList;

}
