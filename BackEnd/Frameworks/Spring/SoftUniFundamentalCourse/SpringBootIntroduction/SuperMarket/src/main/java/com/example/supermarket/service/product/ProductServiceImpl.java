package com.example.supermarket.service.product;

import com.example.supermarket.domain.entity.Category;
import com.example.supermarket.domain.entity.Product;
import com.example.supermarket.repos.CategoryRepository;
import com.example.supermarket.repos.ProductRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Set;


@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private Validator validator;

    @Override
    public void add(String[] productInfo) {
        try{
            BigDecimal price = new BigDecimal(productInfo[1]);
            LocalDate date = LocalDate.parse(productInfo[2], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            Product product = new Product(date,productInfo[0] , price);
            Set<ConstraintViolation<Product>> validate = validator.validate(product);
            if(!validate.isEmpty()){
                validate.forEach(m-> System.out.println(m.getMessage()));
                return;
            }
            Optional<Category> category = categoryRepository.findByName(productInfo[3]);
            if(category.isEmpty()){
                System.out.println("category of that name doesnt exist");
                return;
            }
            product.setCategory(category.get());
            productRepository.save(product);
            System.out.println("Successfuly added product!");
        }catch (Exception e){
            System.out.println("price must be number , date must a date");
        }
    }
}
