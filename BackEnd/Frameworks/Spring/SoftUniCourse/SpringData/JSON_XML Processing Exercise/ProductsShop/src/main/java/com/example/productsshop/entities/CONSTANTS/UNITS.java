package com.example.productsshop.entities.CONSTANTS;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum UNITS {
    ;
    public static final ModelMapper MODEL_MAPPER = new ModelMapper();
    public static final Gson GSON = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();

    public static final Path PATH_TO_PRODUCT_IN_RANGE_JSON
            =Paths.get("src\\main\\resources\\ANSWERS\\products-in-range.json");
    public static final Path PATH_TO_SOLD_PRODUCTS_JSON
            =Paths.get("src\\main\\resources\\ANSWERS\\users-sold-products.json");
    public static final Path PATH_TO_SUMMARY_CATEGORY_JSON
            =Paths.get("src\\main\\resources\\ANSWERS\\categories-by-products.json");
    public static final Path PATH_TO_ALL_USERS_INFO_JSON
            =Paths.get("src\\main\\resources\\ANSWERS\\users-and-products.json");



    public static final Path PATH_TO_PRODUCT_IN_RANGE_XML
            =Paths.get("src\\main\\resources\\ANSWERS\\products-in-range.xml");
    public static final Path PATH_TO_SOLD_PRODUCTS_XML
            =Paths.get("src\\main\\resources\\ANSWERS\\users-sold-products.xml");
    public static final Path PATH_TO_SUMMARY_CATEGORY_XML
            =Paths.get("src\\main\\resources\\ANSWERS\\categories-by-products.xml");
    public static final Path PATH_TO_ALL_USERS_INFO_XML
            =Paths.get("src\\main\\resources\\ANSWERS\\users-and-products.xml");

}
