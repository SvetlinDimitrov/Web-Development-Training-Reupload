package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Knights_of_Honor_02_again_list {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        Consumer<String> print = e->System.out.println("Sir "+e);

        list.forEach(print);
    }
}
