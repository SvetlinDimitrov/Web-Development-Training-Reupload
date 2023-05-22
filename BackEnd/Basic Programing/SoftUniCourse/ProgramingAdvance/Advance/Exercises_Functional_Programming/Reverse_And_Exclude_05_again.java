package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;

public class Reverse_And_Exclude_05_again {
    public static int number;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        number = Integer.parseInt(scanner.nextLine());

        Function<int[] , Integer[]> reversed = array ->{
            Integer [] numbers = new Integer[array.length];
            int count =0;
            for (int i = array.length-1; i >= 0; i--) {
                numbers[count] = array[i];
                count++;
            }
            return numbers;
        };
        reversed.apply(arr);
        System.out.println(String.join(" ",
                Arrays.stream(reversed.apply(arr)).filter(e->e%number!=0)
                        .map(String::valueOf)
                        .toArray(String[]::new)));

    }
}
