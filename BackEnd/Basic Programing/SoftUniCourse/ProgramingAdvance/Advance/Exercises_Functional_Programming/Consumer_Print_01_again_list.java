package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Consumer_Print_01_again_list {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        Consumer<String> print = System.out::println;

        list.forEach(print);
    }
}
