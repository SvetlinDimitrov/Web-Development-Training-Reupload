package JavaAdvance.Exercises_Functional_Programming;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Consumer_Print_01_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] names = scanner.nextLine().split("\\s+");
        Consumer<String> print = System.out::println;
        Arrays.stream(names).forEach(print);
    }
}
