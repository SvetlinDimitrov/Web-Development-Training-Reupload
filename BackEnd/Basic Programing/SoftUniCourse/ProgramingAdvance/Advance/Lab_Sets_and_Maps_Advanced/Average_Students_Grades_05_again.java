package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.awt.*;
import java.util.*;

public class Average_Students_Grades_05_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Map<String , ArrayList<Double>> map = new TreeMap<>();

        for (int i = 0; i < times; i++) {
            String input = scanner.nextLine();
            String name = input.split(" ")[0];
            double grade = Double.parseDouble(input.split(" ")[1]);
            map.putIfAbsent(name , new ArrayList<>());
            map.get(name).add(grade);
        }
        for(Map.Entry<String , ArrayList<Double>> print : map.entrySet()){
            System.out.printf("%s -> ",print.getKey());
            for (Double aDouble : print.getValue()) {
                System.out.printf("%.2f ",aDouble);
            }
            System.out.printf("(avg: %.2f)",print.getValue().stream().mapToDouble(e->e)
                    .average().orElse(0));
            System.out.println();
        }
    }
}
