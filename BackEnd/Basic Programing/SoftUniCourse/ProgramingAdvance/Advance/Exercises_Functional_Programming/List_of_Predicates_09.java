package JavaAdvance.Exercises_Functional_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class List_of_Predicates_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        Integer[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        
    }
}
