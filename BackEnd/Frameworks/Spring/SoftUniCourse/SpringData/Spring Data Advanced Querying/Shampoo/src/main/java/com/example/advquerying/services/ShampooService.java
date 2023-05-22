package com.example.advquerying.services;


import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.util.List;

public interface ShampooService {
    List<Shampoo> selectShampoosBySize(Size size);
    List<Shampoo> selectShampoosBySizeOrLabel(Size size , long label_id);
    List<Shampoo> selectShampoosByPrice(double price);
    Integer countShampoosByPrice(double price);
    List<Shampoo> selectShampoosByIngredients(List<String> ingredients);
    List<Shampoo> selectShampoosByIngredientsCount(int count);

}
