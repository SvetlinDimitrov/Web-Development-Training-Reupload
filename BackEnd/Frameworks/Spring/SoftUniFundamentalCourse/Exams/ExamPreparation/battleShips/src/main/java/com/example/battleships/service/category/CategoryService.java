package com.example.battleships.service.category;

import com.example.battleships.domain.constants.CategoryConstants;
import com.example.battleships.domain.entity.Category;

public interface CategoryService {
    Category findByCategoryName(CategoryConstants category);
}
