package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Average_Students_Grades_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Map<String , ArrayList<Double>> map = new TreeMap<>();

        for (int i = 0; i < times; i++) {
            String input = scanner.nextLine();
            String name = input.split(" ")[0];
            double grade = Double.parseDouble(input.split(" ")[1]);
            if(!map.containsKey(name)){
                map.put(name , new ArrayList<>());
                map.get(name).add(grade);
            }else{
                map.get(name).add(grade);
            }
        }
        for (Map.Entry<String , ArrayList<Double>> entry : map.entrySet()){
            double averageGrade = 0;
            System.out.printf("%s -> ",entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                averageGrade+=entry.getValue().get(i);
                System.out.printf("%.2f ",entry.getValue().get(i));
            }
            System.out.printf("(avg: %.2f)",averageGrade/entry.getValue().size());
            System.out.println();
        }
    }
}
