package JavaAdvance.Functional_Programming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sort_Even_Numbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(e -> e%2==0)
                .toArray();
        String print = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(print);

        System.out.println(Arrays.stream(arr)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
