package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repos.ShampooRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShampooServiceImp implements ShampooService {
    private ShampooRepo shampooRepo;

    @Autowired
    public ShampooServiceImp(ShampooRepo shampooRepo) {
        this.shampooRepo = shampooRepo;
    }

    @Override
    public List<Shampoo> selectShampoosBySize(Size size) {
        return shampooRepo.findAllBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> selectShampoosBySizeOrLabel(Size size, long label) {
        return shampooRepo.findAllBySizeOrLabel_IdOrderByPriceAsc(size , label);
    }

    @Override
    public List<Shampoo> selectShampoosByPrice(double price) {
        BigDecimal bigDecimal = new BigDecimal(price);
        return shampooRepo.findAllByPriceOrderByPriceDesc(bigDecimal);
    }

    @Override
    public Integer countShampoosByPrice(double price) {
        BigDecimal bigDecimal = BigDecimal.valueOf(price);
        return shampooRepo.countAllByPriceLessThan(bigDecimal);
    }

    @Override
    public List<Shampoo> selectShampoosByIngredients(List<String> ingredients) {
        Set<String> set = new HashSet<>();
        return shampooRepo.findAllByIngredientsName(ingredients)
                .stream()
                .filter(s -> {
                    if(!set.contains(s.getBrand())){
                        set.add(s.getBrand());
                        return true;
                    }
                    return false;
                })
                .toList();
    }

    @Override
    public List<Shampoo> selectShampoosByIngredientsCount(int count) {
        return shampooRepo.findAllByIngredientsCount(count);
    }

}
