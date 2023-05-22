package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Custom_Min_Function_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<int[] , Integer> smallest = num ->{
            int value = Integer.MAX_VALUE;
            for (Integer integer : num) {
                if (value > integer) {
                    value = integer;
                }
            }
            return value;
        };
        int [] arr =Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                                .toArray();

        System.out.println(smallest.apply(arr));
    }
}
