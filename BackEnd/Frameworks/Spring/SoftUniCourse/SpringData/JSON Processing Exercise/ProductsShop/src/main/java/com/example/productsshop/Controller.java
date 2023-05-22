package com.example.productsshop;

import com.example.productsshop.entities.Dtos.Json.CategorySummary;
import com.example.productsshop.entities.Dtos.Json.ProductDto;
import com.example.productsshop.entities.Dtos.Json.usersAndProducts.AllUsers;
import com.example.productsshop.entities.Dtos.XML.categories.CategorySummaryDto;
import com.example.productsshop.entities.Dtos.XML.categories.CategorySummaryDtoWrapper;
import com.example.productsshop.entities.Dtos.XML.product.ProductXMLDto;
import com.example.productsshop.entities.Dtos.XML.product.ProductXMLDtoWrapper;
import com.example.productsshop.entities.Dtos.XML.user.UserSoldProductsDtoWrapper;
import com.example.productsshop.entities.Dtos.XML.user.UserXMLDto;
import com.example.productsshop.entities.Dtos.XML.user.UserXMLDtoWrapper;
import com.example.productsshop.entities.products.Product;
import com.example.productsshop.entities.users.User;
import com.example.productsshop.entities.Dtos.Json.UserDtoSoldResponse;
import com.example.productsshop.services.CategoryService;
import com.example.productsshop.services.ProductService;
import com.example.productsshop.services.SeedService;
import com.example.productsshop.services.UserService;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.nio.file.Path;
import java.util.List;

import static com.example.productsshop.entities.CONSTANTS.UNITS.*;
import static java.lang.Boolean.TRUE;

@Component
public class Controller implements CommandLineRunner {
    private SeedService seedService;
    private UserService userService;
    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public Controller(SeedService seedService, UserService userService, ProductService productService, CategoryService categoryService) {
        this.seedService = seedService;
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedService.seedAll();

        ProductsInRangeXML();
        ProductsInRangeJSON();

         SuccessFullySoldJson();
        SuccessFullySoldXml();

        categorySummaryJason();
        categorySummaryXml();

        usersAndProductsJson();
        usersAndProductsXml();

    }

    private void usersAndProductsJson() throws IOException {
        List<User> usersList = userService.findAllBySoldProductsBuyerIsNotNullOrderByLastName();
        AllUsers allUsers = User.toAllUsers(usersList);

        Writer writer = new FileWriter(new File(PATH_TO_ALL_USERS_INFO_JSON.toUri()));
        GSON.toJson(allUsers, writer);
        writer.flush();
        writer.close();
    }
    private void usersAndProductsXml() throws IOException, JAXBException {
        List<User> usersList = userService.findAllBySoldProductsBuyerIsNotNullOrderByLastName();
        UserSoldProductsDtoWrapper usersWrapper = new UserSoldProductsDtoWrapper(usersList);

        File file = new File(PATH_TO_ALL_USERS_INFO_XML.toUri());
        JAXBContext jaxbContext = JAXBContext.newInstance(UserSoldProductsDtoWrapper.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT , true);
        marshaller.marshal(usersWrapper , file);
    }

    private void categorySummaryJason() throws IOException {
        List<CategorySummary> categorySummaries = categoryService.CategoriesByProductsCount();
        getWriter(PATH_TO_SUMMARY_CATEGORY_JSON, categorySummaries);
    }
    private void categorySummaryXml() throws IOException, JAXBException {
        List<CategorySummaryDto> list = categoryService.CategoriesByProductsCount()
                .stream()
                .map(CategorySummaryDto::toCategorySummaryDto)
                .toList();
        CategorySummaryDtoWrapper categoriesWrapper = new CategorySummaryDtoWrapper(list);

        File file = new File(PATH_TO_SUMMARY_CATEGORY_XML.toUri());
        JAXBContext jaxbContext = JAXBContext.newInstance(CategorySummaryDtoWrapper.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT , true);
        marshaller.marshal(categoriesWrapper , file);

    }

    private void SuccessFullySoldJson() throws IOException {
        List<UserDtoSoldResponse> list = userService.SuccessfullySoldProducts()
                .stream()
                .map(User::userDtoSoldResponse)
                .toList();
        getWriter(PATH_TO_SOLD_PRODUCTS_JSON, list);
    }

    private void SuccessFullySoldXml() throws IOException, JAXBException {
        List<UserXMLDto> list = userService.SuccessfullySoldProducts()
                .stream()
                .map(UserXMLDto::toUserXmlDto)
                .toList();
        UserXMLDtoWrapper usersWrapper = new UserXMLDtoWrapper(list);
        File file = new File(PATH_TO_SOLD_PRODUCTS_XML.toUri());

        JAXBContext jaxbContext = JAXBContext.newInstance(UserXMLDtoWrapper.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, TRUE);

        marshaller.marshal(usersWrapper, file);
    }

    private void ProductsInRangeJSON() throws IOException {
        List<ProductDto> list = productService.productsInRange()
                .stream()
                .map(p -> MODEL_MAPPER.map(p, ProductDto.class))
                .toList();

        getWriter(PATH_TO_PRODUCT_IN_RANGE_JSON, list);
    }

    private void ProductsInRangeXML() throws IOException, JAXBException {
        List<ProductXMLDto> list = productService.productsInRange()
                .stream()
                .map(ProductXMLDto::toProductXMLDto)
                .toList();
        ProductXMLDtoWrapper productsWrapper = new ProductXMLDtoWrapper(list);

        JAXBContext jaxbContext = JAXBContext.newInstance(ProductXMLDtoWrapper.class);
        File file = new File(PATH_TO_PRODUCT_IN_RANGE_XML.toUri());
        Marshaller marshaller = jaxbContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(productsWrapper, file);


    }


    private void getWriter(Path path, List<?> list) throws IOException {
        Writer writer = new FileWriter(new File(path.toUri()));
        GSON.toJson(list, writer);
        writer.flush();
        writer.close();
    }
}
