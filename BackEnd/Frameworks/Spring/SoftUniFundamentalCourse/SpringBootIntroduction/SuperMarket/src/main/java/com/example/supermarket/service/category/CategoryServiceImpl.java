package com.example.supermarket.service.category;

import com.example.supermarket.domain.entity.Category;
import com.example.supermarket.repos.CategoryRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Setter
@Getter
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private Validator validator;

    @Override
    public void addCategory(Category category) {
        Set<ConstraintViolation<Category>> validate = validator.validate(category);
        if(validate.size() > 0){
            validate.forEach(m-> System.out.println(m.getMessage()));
            return;
        }
        categoryRepository.save(category);
        System.out.println("Successfully added category!");
    }
}
