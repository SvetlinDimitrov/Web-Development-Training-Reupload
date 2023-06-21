package com.example.supermarket.domain.constants;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

import java.util.Map;
import java.util.TreeMap;

public class ENUM {
    ;
    public static final Map<Integer , String> MENU_MAP = new TreeMap<>(){
        {
            put(1, "for Add Category");
            put(2, "for Add Town");
            put(3, "for Add Shop");
            put(4, "for Add Seller");
            put(5, "for Add Product");
            put(6, "Set seller new manager");
            put(7, "for Distributing product in shops");
            put(8, "for Showing all sellers in Shop");
            put(9, "for Showing all products in Shop");
            put(10, "stop the program");
        }};



}
