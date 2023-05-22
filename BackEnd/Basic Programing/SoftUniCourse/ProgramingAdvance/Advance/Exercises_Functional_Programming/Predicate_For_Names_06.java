package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Predicate_For_Names_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());

        Predicate<String> valid = word -> word.length() <= length;

        Arrays.stream(scanner.nextLine().split(" "))
                .filter(valid)
                .forEach(System.out::println);
    }
}
