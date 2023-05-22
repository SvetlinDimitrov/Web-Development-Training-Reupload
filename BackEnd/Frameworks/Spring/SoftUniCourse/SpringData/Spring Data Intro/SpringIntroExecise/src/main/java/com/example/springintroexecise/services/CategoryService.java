package com.example.springintroexecise.services;

import com.example.springintroexecise.entity.Category;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    void registerCategory() throws IOException;
    Set<Category> getRandomCategories();
}
