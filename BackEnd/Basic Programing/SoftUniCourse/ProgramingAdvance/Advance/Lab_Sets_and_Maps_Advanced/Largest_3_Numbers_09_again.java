package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



public class Largest_3_Numbers_09_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((n1,n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

    }
}
