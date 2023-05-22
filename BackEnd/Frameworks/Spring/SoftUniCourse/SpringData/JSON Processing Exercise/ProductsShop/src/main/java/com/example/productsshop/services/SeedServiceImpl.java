package com.example.productsshop.services;

import com.example.productsshop.entities.Dtos.XML.categories.CategoriesDtoImportWrapper;
import com.example.productsshop.entities.Dtos.XML.product.ProductDtoImportWrapper;

import com.example.productsshop.entities.Dtos.XML.user.UserDtoImportWrapper;
import com.example.productsshop.entities.products.Category;
import com.example.productsshop.entities.products.Product;
import com.example.productsshop.entities.users.User;
import com.example.productsshop.entities.Dtos.Json.UserDtoSeed;
import com.example.productsshop.repositories.CategoryRepository;
import com.example.productsshop.repositories.ProductRepository;
import com.example.productsshop.repositories.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static com.example.productsshop.entities.CONSTANTS.UNITS.*;

@Service
public class SeedServiceImpl implements SeedService {

    private UserRepository userRepository;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedUsers() throws IOException, JAXBException {
        if (userRepository.count() != 0) {
            return;
        }

        seedUsersUsingXML();
//        seedUsersUsingJson();

    }

    private void seedUsersUsingXML() throws JAXBException, IOException {

        Reader reader = getReader(PATH_USERS_XML);
        JAXBContext jaxbContext = JAXBContext.newInstance(UserDtoImportWrapper.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        UserDtoImportWrapper unmarshal = (UserDtoImportWrapper)unmarshaller.unmarshal(reader);

        List<User> list = unmarshal.getUsers()
                .stream()
                .map(u -> MODEL_MAPPER.map(u, User.class))
                .toList();
        userRepository.saveAllAndFlush(list);
    }
    private void seedUsersUsingJson() throws IOException {
        Arrays.stream(GSON.fromJson(getReader(PATH_USERS_JSON), UserDtoSeed[].class))
                .toList()
                .stream()
                .map(u -> MODEL_MAPPER.map(u, User.class))
                .filter(u -> u.getLastName().length() >= 3)
                .forEach(u -> userRepository.saveAndFlush(u));
    }


    @Override
    public void seedProducts() throws IOException, JAXBException {
        if (productRepository.count() != 0) {
            return;
        }

        seedProductsUsingXml();
        //seedProductsUsingJson();
    }

    private void seedProductsUsingXml() throws IOException, JAXBException {
        Reader reader = getReader(PATH_PRODUCTS_XML);
        JAXBContext jaxbContext = JAXBContext.newInstance(ProductDtoImportWrapper.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        ProductDtoImportWrapper unmarshal = (ProductDtoImportWrapper)unmarshaller.unmarshal(reader);
        List<Product> list = unmarshal.getProducts()
                .stream()
                .map(p -> MODEL_MAPPER.map(p, Product.class))
                .map(this::setRandomSellerAndBuyer)
                .map(this::setRandomCategories)
                .toList();

        productRepository.saveAllAndFlush(list);
    }
    private void seedProductsUsingJson() throws IOException {

        List<Product> list = Arrays.stream(GSON.fromJson(getReader(PATH_PRODUCTS_JSON), Product[].class))
                .map(this::setRandomSellerAndBuyer)
                .map(this::setRandomCategories)
                .toList();

        productRepository.saveAllAndFlush(list);
    }
    public Product setRandomSellerAndBuyer (Product product){
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

    public Product setRandomCategories(Product product){
        long categorySize = categoryRepository.count();
        Set<Category> categories = new HashSet<>();

        for (int i = 0; i < getRandomNumber(10); i++) {
            categories.add(categoryRepository.findById(getRandomNumber(categorySize)).orElseThrow());
        }

        product.getCategories().addAll(categories);

        return product;
    }


    @Override
    public void seedCategories() throws IOException, JAXBException {
        if (categoryRepository.count() != 0) {
            return;
        }

        seedCategoriesUsingXml();
        //seedCategoriesUsingJson();

    }

    private void seedCategoriesUsingXml() throws IOException, JAXBException {
        Reader reader = getReader(PATH_CATEGORIES_XML);
        JAXBContext jaxbContext = JAXBContext.newInstance(CategoriesDtoImportWrapper.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        CategoriesDtoImportWrapper categoryWrapper = (CategoriesDtoImportWrapper) unmarshaller.unmarshal(reader);

        List<Category> list = categoryWrapper.getCategories()
                .stream()
                .map(p -> MODEL_MAPPER.map(p, Category.class))
                .toList();
        categoryRepository.saveAllAndFlush(list);
    }

    private void seedCategoriesUsingJson() throws IOException {
        categoryRepository.saveAll(
                Arrays.stream(
                                GSON.fromJson(
                                        getReader(PATH_CATEGORIES_JSON), Category[].class))
                        .toList());
    }


    private Reader getReader(Path path) throws IOException {
        return Files.newBufferedReader(path);
    }

    private long getRandomNumber(long count) {
        Random random = new Random();
        return random.nextLong(1, count) + 1;
    }

}
