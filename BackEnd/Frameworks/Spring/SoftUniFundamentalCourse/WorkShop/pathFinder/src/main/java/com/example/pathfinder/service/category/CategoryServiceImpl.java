package com.example.pathfinder.service.category;

import com.example.pathfinder.domain.bindingViews.ViewCategorie;
import com.example.pathfinder.domain.constants.CategoryConstant;
import com.example.pathfinder.domain.entity.Categorie;
import com.example.pathfinder.repos.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;


    @Override
    public List<ViewCategorie> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(ViewCategorie::new)
                .toList();
    }

    @Override
    public Categorie findByCategoryConstant(CategoryConstant categoryConstant) {
        return categoryRepository.findByName(categoryConstant).orElseThrow(() -> new RuntimeException("There are two same categories"));
    }
}
