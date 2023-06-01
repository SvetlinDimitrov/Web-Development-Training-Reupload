package com.example.supermarket;

import com.example.supermarket.domain.constants.ENUM;
import com.example.supermarket.domain.entity.Category;
import com.example.supermarket.domain.entity.Shop;
import com.example.supermarket.domain.entity.Town;
import com.example.supermarket.service.category.CategoryService;

import com.example.supermarket.service.product.ProductService;
import com.example.supermarket.service.seller.SellerService;
import com.example.supermarket.service.shop.ShopService;
import com.example.supermarket.service.town.TownService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.Scanner;


@Component
@AllArgsConstructor
public class Main implements CommandLineRunner {
    private Scanner scanner;
    private CategoryService categoryService;
    private TownService townService;
    private ShopService shopService;
    private SellerService sellerService;
    private ProductService productService;


    @Override
    public void run(String... args) throws Exception {

        int commandNumber;
        String input = "";

        while (!input.equals("10")) {

            ENUM.MENU_MAP.forEach((key, value) -> System.out.println(key + " - " + value));
            input = scanner.nextLine();
            commandNumber = convertNumber(input);

            if (commandNumber == -1) {
                continue;
            }

            switch (commandNumber) {
                case 1:
                    System.out.println("Enter category name:");
                    String categoryName = scanner.nextLine();
                    Category category = new Category(categoryName);
                    categoryService.addCategory(category);
                    break;
                case 2:
                    System.out.println("Enter town name:");
                    String townName = scanner.nextLine();
                    Town town = new Town(townName);
                    townService.add(town);
                    break;
                case 3:
                    System.out.println("Enter shop details:name address town");
                    String [] shopInfo = scanner.nextLine().split(" ");
                    shopService.add(shopInfo);
                    break;
                case 4:
                    System.out.println("Enter seller details:firstName lastName age salary shopName");
                    String [] sellerInfo = scanner.nextLine().split(" ");
                    sellerService.add(sellerInfo);
                    break;
                case 5:
                    System.out.println("Enter product details:name price bestBefore(dd-MM-yyyy) category");
                    String [] productInfo = scanner.nextLine().split(" ");
                    productService.add(productInfo);
                    break;
                case 6:
                    System.out.println("Enter seller firstName and lastName");
                    String [] seller = scanner.nextLine().split(" ");
                    System.out.println("Enter manager firstName and lastName");
                    String [] manager = scanner.nextLine().split(" ");
                    sellerService.addManagerToSeller(seller , manager);
                    break;
            }
            System.out.println("==============================================");

        }

    }

    private int convertNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("You ust write a number");
            return -1;
        }
    }
}
