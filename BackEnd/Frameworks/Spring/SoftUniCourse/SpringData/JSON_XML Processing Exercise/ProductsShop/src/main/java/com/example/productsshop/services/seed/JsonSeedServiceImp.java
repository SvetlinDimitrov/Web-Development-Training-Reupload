package com.example.productsshop.services.seed;

import com.example.productsshop.entities.Dtos.Json.UserDtoSeed;
import com.example.productsshop.entities.products.Category;
import com.example.productsshop.entities.products.Product;
import com.example.productsshop.entities.users.User;
import com.example.productsshop.repositories.CategoryRepository;
import com.example.productsshop.repositories.ProductRepository;
import com.example.productsshop.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static com.example.productsshop.entities.CONSTANTS.UNITS.GSON;
import static com.example.productsshop.entities.CONSTANTS.UNITS.MODEL_MAPPER;

@Component
public class JsonSeedServiceImp extends SeedService {
    private final Path PATH_USERS_JSON
            = Paths.get("src\\main\\resources\\09. DB-Advanced-JSON-Processing-Exercises-Resources\\users.json");
    private final Path PATH_CATEGORIES_JSON
            = Paths.get("src\\main\\resources\\09. DB-Advanced-JSON-Processing-Exercises-Resources\\categories.json");
    private final Path PATH_PRODUCTS_JSON
            = Paths.get("src\\main\\resources\\09. DB-Advanced-JSON-Processing-Exercises-Resources\\products.json");

    @Override
    void seedUsers() throws IOException {
        Arrays.stream(GSON.fromJson(getReader(PATH_USERS_JSON), UserDtoSeed[].class))
                .toList()
                .stream()
                .map(u -> MODEL_MAPPER.map(u, User.class))
                .filter(u -> u.getLastName().length() >= 3)
                .forEach(u -> userRepository.saveAndFlush(u));
    }

    @Override
    void seedProducts() throws IOException {

        List<Product> list = Arrays.stream(GSON.fromJson(getReader(PATH_PRODUCTS_JSON), Product[].class))
                .map(this::setRandomSellerAndBuyer)
                .map(this::setRandomCategories)
                .toList();
        productRepository.saveAllAndFlush(list);
    }

    @Override
    void seedCategories() throws IOException {
        categoryRepository.saveAll(
                Arrays.stream(
                                GSON.fromJson(
                                        getReader(PATH_CATEGORIES_JSON), Category[].class))
                        .toList());
    }
}
