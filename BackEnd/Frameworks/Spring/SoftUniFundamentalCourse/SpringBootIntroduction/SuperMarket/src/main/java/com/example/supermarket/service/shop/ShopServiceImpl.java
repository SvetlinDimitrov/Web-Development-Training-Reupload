package com.example.supermarket.service.shop;

import com.example.supermarket.domain.entity.Shop;
import com.example.supermarket.domain.entity.Town;
import com.example.supermarket.repos.ShopRepository;
import com.example.supermarket.repos.TownRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class ShopServiceImpl implements ShopService {
    private ShopRepository shopRepository;
    private TownRepository townRepository;
    private Validator validator;

    @Override
    public void add(String[] info) {
        Shop shop = new Shop(info[1] , info[0]);
        Town town = townRepository.findByName(info[2]);
        Set<ConstraintViolation<Shop>> validate = validator.validate(shop);

        if(validate.isEmpty() && town != null){
            shop.setTown(town);
            shopRepository.save(shop);
            System.out.println("Successfully added shop");
            return;
        }

        validate.forEach(m-> System.out.println(m.getMessage()));
        if(town == null){
            System.out.println("There is no town with that name");
        }
    }
}
