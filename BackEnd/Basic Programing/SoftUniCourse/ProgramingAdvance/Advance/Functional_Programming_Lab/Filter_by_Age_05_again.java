package JavaAdvance.Functional_Programming_Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Filter_by_Age_05_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Map<String , Integer> map = new LinkedHashMap<>();
        String name;
        int age;
        for (int i = 0; i < times; i++) {
            String input = scanner.nextLine();
            name = input.split(", ")[1];
            age = Integer.parseInt(input.split(", ")[1]);
            map.putIfAbsent(name , age);
        }
        String ageCondition = scanner.nextLine();
        int ageConditionNum = Integer.parseInt(scanner.nextLine());
        String printFormat = scanner.nextLine();

        Predicate<Integer> ConditionOlder = x-> x>ageConditionNum;


    }
}
