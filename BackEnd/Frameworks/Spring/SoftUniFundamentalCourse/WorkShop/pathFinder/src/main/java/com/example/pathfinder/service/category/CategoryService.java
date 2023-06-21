package com.example.pathfinder.service.category;

import com.example.pathfinder.domain.bindingViews.ViewCategories;
import com.example.pathfinder.domain.constants.CategoryConstant;
import com.example.pathfinder.domain.entity.Categorie;

import java.util.List;

public interface CategoryService {
    List<ViewCategories> getAllCategories();

    Categorie findByCategoryConstant(CategoryConstant categoryConstant);
}
