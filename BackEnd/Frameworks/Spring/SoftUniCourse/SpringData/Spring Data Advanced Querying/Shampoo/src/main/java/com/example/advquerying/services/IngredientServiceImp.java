package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repos.IngredientsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class IngredientServiceImp implements IngredientService{
    private IngredientsRepo ingredientsRepo;

    @Autowired
    public IngredientServiceImp(IngredientsRepo ingredientsRepo) {
        this.ingredientsRepo = ingredientsRepo;
    }

    @Override
    public List<Ingredient> selectIngredientsByName(String name) {
        return ingredientsRepo.findAllByNameStartingWith(name);
    }

    @Override
    public List<Ingredient> selectIngredientsByNames(List<String> names) {
        return ingredientsRepo.findAllByNameInOrderByPrice(names);
    }

    @Override
    @Transactional
    public boolean deleteIngredientsByName(String name) {
        List<Ingredient> all = ingredientsRepo.findAll();
        ingredientsRepo.deleteByName(name);
        return all.size() != ingredientsRepo.findAll().size();
    }
}
