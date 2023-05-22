package com.example.productsshop.services;

import com.example.productsshop.entities.Dtos.Json.CategorySummary;

import java.util.List;

public interface CategoryService {
    List<CategorySummary> CategoriesByProductsCount();
}
