package org.example;

import org.example.factories.JavaShop;
import org.example.factories.PythonShop;
import org.example.factories.SharpShop;

public class Main {
    public static void main(String[] args) {
        ShopFactory javaShop = new JavaShop();
        javaShop.printCurrentStocks();

        ShopFactory pythonShop = new PythonShop();
        pythonShop.printCurrentStocks();

        ShopFactory sharpShop = new SharpShop();
        sharpShop.printCurrentStocks();
    }
}