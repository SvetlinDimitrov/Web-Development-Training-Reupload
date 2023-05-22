package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.util.*;

public class Product_Shop_06_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , Map<String , Double>> map = new TreeMap<>();
        String input = scanner.nextLine();
        while(!input.equals("Revision")){
            String market = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);
            map.putIfAbsent(market , new LinkedHashMap<>());
            map.get(market).put(product , price);

            input = scanner.nextLine();
        }
        for(Map.Entry<String , Map<String , Double>> print : map.entrySet()){
            System.out.printf("%s->%n",print.getKey());
            for(Map.Entry<String , Double> print2 : print.getValue().entrySet()){
                System.out.printf("Product: %s, Price: %.1f%n",print2.getKey(),print2.getValue());
            }
        }
    }
}
