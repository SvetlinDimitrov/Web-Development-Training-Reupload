package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Product_Shop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , Map<String , Double>> map = new TreeMap<>();
        String input = scanner.nextLine();
        while(!input.equals("Revision")){
            String store = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);
            if(!map.containsKey(store)){
                map.put(store , new LinkedHashMap<>());
                map.get(store).put(product , price);
            }else{
                map.get(store).put(product ,price);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String , Map<String , Double>> mainEntry : map.entrySet()){
            System.out.printf("%s->%n",mainEntry.getKey());
            for (Map.Entry<String , Double> entry : mainEntry.getValue().entrySet()){
                System.out.printf("Product: %s, Price: %.1f%n",entry.getKey(),entry.getValue());
            }
        }
    }
}
