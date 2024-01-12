package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> selectIngredientsByName(String name);
    List<Ingredient> selectIngredientsByNames(List<String> names);
    boolean deleteIngredientsByName(String name);
}
