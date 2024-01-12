package JavaAdvance.Functional_Programming_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Sum_Numbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long count = Arrays.stream(arr)
                .count();
        System.out.println("Count = " + count);
        int sum = Arrays.stream(arr)
                .sum();
        System.out.println("Sum = " + sum);
    }
}
