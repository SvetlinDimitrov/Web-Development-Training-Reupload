package com.example.productsshop.services.seed;

import com.example.productsshop.entities.Dtos.XML.categories.CategoriesDtoImportWrapper;
import com.example.productsshop.entities.Dtos.XML.product.ProductDtoImportWrapper;

import com.example.productsshop.entities.Dtos.XML.user.UserDtoImportWrapper;
import com.example.productsshop.entities.products.Category;
import com.example.productsshop.entities.products.Product;
import com.example.productsshop.entities.users.User;
import com.example.productsshop.repositories.CategoryRepository;
import com.example.productsshop.repositories.ProductRepository;
import com.example.productsshop.repositories.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static com.example.productsshop.entities.CONSTANTS.UNITS.*;

@Service
public class XmlSeedServiceImp extends SeedService {
    private final Path PATH_USERS_XML
            = Paths.get("src\\main\\resources\\09. XML-Processing-Exercises\\users.xml");
    private final Path PATH_CATEGORIES_XML
            =Paths.get("src\\main\\resources\\09. XML-Processing-Exercises\\categories.xml");
    private final Path PATH_PRODUCTS_XML
            =Paths.get("src\\main\\resources\\09. XML-Processing-Exercises\\products.xml");


    @Autowired
    public XmlSeedServiceImp(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedUsers() throws IOException, JAXBException {
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


    @Override
    public void seedProducts() throws IOException, JAXBException {
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


    @Override
    public void seedCategories() throws IOException, JAXBException {
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

}
