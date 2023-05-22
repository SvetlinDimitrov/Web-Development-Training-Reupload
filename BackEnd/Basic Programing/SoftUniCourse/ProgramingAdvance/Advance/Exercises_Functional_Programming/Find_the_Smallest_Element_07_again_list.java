package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Find_the_Smallest_Element_07_again_list {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int min = Collections.min(list);

        System.out.println(list.indexOf(min));
    }
}
