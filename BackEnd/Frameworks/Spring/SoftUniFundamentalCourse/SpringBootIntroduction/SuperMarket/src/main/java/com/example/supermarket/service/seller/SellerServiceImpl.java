package com.example.supermarket.service.seller;

import com.example.supermarket.domain.entity.Seller;
import com.example.supermarket.domain.entity.Shop;
import com.example.supermarket.repos.SellerRepository;
import com.example.supermarket.repos.ShopRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class SellerServiceImpl implements SellerService {
    private SellerRepository sellerRepository;
    private ShopRepository shopRepository;
    private Validator validator;

    @Override
    public void add(String[] sellerInfo) {
        try{
            int age = Integer.parseInt(sellerInfo[2]);
            BigDecimal salary = new BigDecimal(sellerInfo[3]);
            Seller seller = new Seller(sellerInfo[0] , sellerInfo[1] , age , salary);
            Set<ConstraintViolation<Seller>> validate = validator.validate(seller);

            if(!validate.isEmpty()){
                validate.forEach(m-> System.out.println(m.getMessage()));
                return;
            }

            Optional<Shop> shop = shopRepository.findByName(sellerInfo[4]);
            if(shop.isEmpty()){
                System.out.println("there is no shop with that name");
                return;
            }

            seller.setShop(shop.get());
            sellerRepository.save(seller);
            System.out.println("Successfully added seller!");
        }catch (Exception e){
            System.out.println("age and salary must be numbers");
        }

    }

    @Override
    public void addManagerToSeller(String[] sellerInfo, String[] managerInfo) {
        Optional<Seller> seller = sellerRepository.findByFirstNameAndLastName(sellerInfo[0], sellerInfo[1]);
        if(seller.isEmpty()){
            System.out.println("There is no seller with that names");
            return;
        }
        if(seller.get().getManager() != null){
            System.out.println("He already has a manager");
            return;
        }
        Optional<Seller> manager = sellerRepository.findByFirstNameAndLastName(managerInfo[0], managerInfo[1]);
        if(manager.isEmpty()){
            System.out.println("There is no manager with that names");
            return;
        }
        seller.get().setManager(manager.get());
        sellerRepository.setManager(seller.get().getId() , manager.get());
        System.out.println("Successfuly added manager!");
    }
}
