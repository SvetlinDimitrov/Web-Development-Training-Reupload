package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Knights_of_Honor_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> print = word -> System.out.println("Sir " + word);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(print);
    }
}
