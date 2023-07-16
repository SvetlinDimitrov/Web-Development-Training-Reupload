package com.example.productsshop.services.seed;

import com.example.productsshop.entities.products.Category;
import com.example.productsshop.entities.products.Product;
import com.example.productsshop.entities.users.User;
import com.example.productsshop.repositories.CategoryRepository;
import com.example.productsshop.repositories.ProductRepository;
import com.example.productsshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public abstract class SeedService {
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected ProductRepository productRepository;
    @Autowired
    protected CategoryRepository categoryRepository;

    abstract void seedUsers() throws IOException, JAXBException;
    abstract void seedProducts() throws IOException , JAXBException;
    abstract void seedCategories() throws IOException , JAXBException;
    public void seedAll() throws IOException , JAXBException {
        if(userRepository.count() == 0){
            seedUsers();
        }
        if(categoryRepository.count() == 0){
            seedCategories();
        }

        if(productRepository.count() == 0){
            seedProducts();
        }
    }

    protected Reader getReader(Path path) throws IOException {
        return Files.newBufferedReader(path);
    }
    protected long getRandomNumber(long count) {
        Random random = new Random();
        return random.nextLong(1, count) + 1;
    }

    protected Product setRandomSellerAndBuyer (Product product){
        long userCounts = userRepository.count();

        User buyer = userRepository.findById(getRandomNumber(userCounts)).orElseThrow();
        User seller = userRepository.findById(getRandomNumber(userCounts)).orElseThrow();

        while (buyer.equals(seller)) {
            seller = userRepository.findById(getRandomNumber(userCounts)).orElseThrow();
        }

        product.setSeller(seller);
        Random random = new Random();

        if(random.nextBoolean()){
            product.setBuyer(buyer);
        }

        return product;
    }

    protected Product setRandomCategories(Product product){
        long categorySize = categoryRepository.count();
        Set<Category> categories = new HashSet<>();

        for (int i = 0; i < getRandomNumber(10); i++) {
            categories.add(categoryRepository.findById(getRandomNumber(categorySize)).orElseThrow());
        }

        product.getCategories().addAll(categories);

        return product;
    }
}
