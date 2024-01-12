package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Reverse_and_Exclude_05_again_list {
    public static int del;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        del = Integer.parseInt(scanner.nextLine());

        Collections.reverse(list);

        list.stream().filter(e-> e%del != 0)
                .forEach(e-> System.out.printf("%d ",e));

    }
}
