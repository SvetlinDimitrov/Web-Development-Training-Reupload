package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Predicate_for_Names_06_again_list {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int condition = Integer.parseInt(scanner.nextLine());

        List<String> names = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        names = names.stream().filter(e->e.length() <= condition)
                .collect(Collectors.toList());

        names.forEach(System.out::println);
    }
}
