package com.example.pathfinder.service.category;

import com.example.pathfinder.domain.bindingViews.ViewCategories;
import com.example.pathfinder.domain.constants.CategoryConstant;
import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.domain.entity.Categorie;
import com.example.pathfinder.domain.entity.Role;
import com.example.pathfinder.repos.CategoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper mapper;

    @Override
    public List<ViewCategories> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(c->mapper.map(c, ViewCategories.class))
                .toList();
    }

    @Override
    public Categorie findByCategoryConstant(CategoryConstant categoryConstant) {
        return categoryRepository.findByName(categoryConstant).orElseThrow();
    }
}
