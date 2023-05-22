package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Count_Real_Numbers_04_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double , Integer> map = new LinkedHashMap<>();

        Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble)
                .forEach(e->{
                    map.putIfAbsent(e , 0);
                    map.put(e , map.get(e)+1);
                });
        for(Map.Entry<Double , Integer> print : map.entrySet()){
            System.out.printf("%.1f -> %d%n",print.getKey() , print.getValue());
        }
    }
}
