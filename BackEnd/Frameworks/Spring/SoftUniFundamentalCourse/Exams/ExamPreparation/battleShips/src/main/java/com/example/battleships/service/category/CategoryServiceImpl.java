package com.example.battleships.service.category;

import com.example.battleships.domain.constants.CategoryConstants;
import com.example.battleships.domain.entity.Category;
import com.example.battleships.repos.CategoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @PostConstruct
    public void init(){
        if(categoryRepository.findAll().size() == 0){
            categoryRepository.saveAll(Arrays.stream(CategoryConstants.values())
                    .map(c->new Category(c,"You can skip the description if you want"))
                    .toList());
        }
    }

    @Override
    public Category findByCategoryName(CategoryConstants category) {
        return categoryRepository.findByName(category);
    }
}
