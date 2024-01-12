package JavaAdvance.Functional_Programming_Lab;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sort_Even_Numbers_01_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] nums = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(n-> n%2==0)
                .toArray();

        String toPrint1 = Arrays.stream(nums)
                .mapToObj(Objects::toString)
                .collect(Collectors.joining(", "));
        System.out.println(toPrint1);

        System.out.println(Arrays.stream(nums)
                .sorted()
                .mapToObj(Objects::toString)
                .collect(Collectors.joining(", ")));

    }
}
