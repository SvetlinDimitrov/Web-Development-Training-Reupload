package com.example.productsshop.services.category;

import com.example.productsshop.entities.Dtos.Json.CategorySummary;
import com.example.productsshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategorySummary> CategoriesByProductsCount() {
        return categoryRepository.categorySummary().orElseThrow(RuntimeException::new);
    }
}
