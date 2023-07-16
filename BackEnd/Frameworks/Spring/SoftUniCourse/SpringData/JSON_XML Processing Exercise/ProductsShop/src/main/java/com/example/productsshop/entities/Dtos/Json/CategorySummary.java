package com.example.productsshop.entities.Dtos.Json;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class CategorySummary {
    @Expose
    private String category;
    @Expose
    private Long productsCount;
    @Expose
    private Double averagePrice;
    @Expose
    private BigDecimal totalRevenue;

    public CategorySummary(String category, Long productsCount, Double averagePrice, BigDecimal totalRevenue) {
        this.category = category;
        this.productsCount = productsCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }
}
