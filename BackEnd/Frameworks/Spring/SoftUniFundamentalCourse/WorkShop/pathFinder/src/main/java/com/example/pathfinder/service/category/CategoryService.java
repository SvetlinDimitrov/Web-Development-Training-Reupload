package com.example.pathfinder.service.category;

import com.example.pathfinder.domain.bindingViews.ViewCategorie;
import com.example.pathfinder.domain.constants.CategoryConstant;
import com.example.pathfinder.domain.entity.Categorie;

import java.util.List;

public interface CategoryService {
    List<ViewCategorie> getAllCategories();

    Categorie findByCategoryConstant(CategoryConstant categoryConstant);
}
