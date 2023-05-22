package com.example.advquerying;

import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Controller  implements CommandLineRunner {
    private Scanner scanner = new Scanner(System.in);
    private ShampooService shampooService;
    private IngredientService ingredientService;

    @Autowired
    public Controller(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
//        String sizeString = scanner.nextLine();
//        String labelString = scanner.nextLine();
//        Size size = Size.valueOf(sizeString);
//        long labelId = Long.parseLong(labelString);
//        shampooService.selectShampoosBySize(Size.valueOf(s))
//                .forEach(shampoo -> System.out.printf("%s %s %.2slv.%n",shampoo.getBrand(),shampoo.getSize(),shampoo.getPrice()));
//        shampooService.selectShampoosBySizeOrLabel(size,labelId)
//                .forEach(shampoo -> System.out.printf("%s %s %s .%n",shampoo.getBrand(),shampoo.getSize(),shampoo.getPrice()));
//        String s = scanner.nextLine();
//        double v = Double.parseDouble(s);
//        shampooService.selectShampoosByPrice(v)
//                .forEach(shampoo -> System.out.printf("%s %s %slv.%n",shampoo.getBrand(),shampoo.getSize(),shampoo.getPrice()));
//        String s = scanner.nextLine();
//        ingredientService.selectIngredientsByName(s)
//                .forEach(ing -> System.out.println(ing.getName()));
//        String s = scanner.nextLine();
//
//        List<String> names = new ArrayList<>();
//        while(!s.isBlank()){
//            names.add(s);
//             s = scanner.nextLine();
//        }
//        ingredientService.selectIngredientsByNames(names)
//                .forEach(ing -> System.out.println(ing.getName()));

//        String s = scanner.nextLine();
//        double v = Double.parseDouble(s);
//        System.out.println(shampooService.countShampoosByPrice(v));

//        String s = scanner.nextLine();
//        List<String> names = new ArrayList<>();
//        while(!s.isBlank()){
//            names.add(s);
//             s = scanner.nextLine();
//        }
//        shampooService.selectShampoosByIngredients(names)
//                .forEach(shampoo -> System.out.println(shampoo.getBrand()));

//        String s = scanner.nextLine();
//        int v = Integer.parseInt(s);
//        shampooService.selectShampoosByIngredientsCount(v)
//                .forEach(shampoo -> System.out.println(shampoo.getBrand()));

        boolean apple = ingredientService.deleteIngredientsByName("Apple");
        System.out.println(apple);
    }
}
