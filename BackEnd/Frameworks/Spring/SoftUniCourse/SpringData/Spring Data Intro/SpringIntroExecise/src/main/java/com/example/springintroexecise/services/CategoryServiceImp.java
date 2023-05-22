package com.example.springintroexecise.services;

import com.example.springintroexecise.entity.Author;
import com.example.springintroexecise.entity.Category;
import com.example.springintroexecise.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImp implements CategoryService{
    private CategoryRepo categoryRepo;
    private static final String RESOURCE_PATH = "D:\\Web Development\\SoftUni\\SpringData\\Spring Data Intro\\SpringIntroExecise\\src\\main\\resources\\files\\";
    private static final String CATEGORY_FILE_NAME = "categories.txt";

    @Autowired
    public CategoryServiceImp(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void registerCategory() throws IOException {
        if(categoryRepo.findAll().isEmpty()){
            List<Category> categories = Files.readAllLines(Path.of(RESOURCE_PATH + CATEGORY_FILE_NAME))
                    .stream()
                    .filter(e->!e.isBlank())
                    .map(row -> new Category(row))
                    .toList();
            categoryRepo.saveAll(categories);
        }
    }

    @Override
    public Set<Category> getRandomCategories() {
        List<Category> categories = categoryRepo.findAll();
        if(categories.isEmpty()){
            throw new RuntimeException("nqma kategorii");
        }
        Set<Category> set = new HashSet<>();
        Random randomInt = new Random();
        int random = randomInt.nextInt(1, categories.size());
        for (int i = 0; i < random; i++) {
            int randomIndex = randomInt.nextInt(0, categories.size());
            set.add(categories.get(randomIndex));
        }
        return set;
    }
}
