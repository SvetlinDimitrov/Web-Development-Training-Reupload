package com.example.supermarket.service.category;

import com.example.supermarket.domain.entity.Category;
import com.example.supermarket.repos.CategoryRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
@Setter
@Getter
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public void addCategory(Category category) {

    }
}
