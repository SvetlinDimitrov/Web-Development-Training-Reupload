package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Count_Real_Numbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double , Integer> map = new LinkedHashMap<>();
                Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .forEach(n -> {
                    map.putIfAbsent(n , 0);
                    int currentNum= map.get(n);
                    map.put(n , currentNum +1);
                });
        for (Map.Entry<Double , Integer> entry : map.entrySet()){
            System.out.printf("%.1f -> %d%n",entry.getKey() , entry.getValue());
        }
    }
}
