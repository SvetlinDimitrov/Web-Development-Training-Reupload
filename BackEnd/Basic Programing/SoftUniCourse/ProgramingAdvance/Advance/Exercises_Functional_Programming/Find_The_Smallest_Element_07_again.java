package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Function;

public class Find_The_Smallest_Element_07_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<int[] , Integer> indexOf = numbers->{
            OptionalInt min = Arrays.stream(numbers).min();
            int index =0;
            for (int i = 0; i < numbers.length; i++) {
                if(min.orElse(0) == numbers[i]){
                    index = i;
                    break;
                }
            }
            return index;
        };


        int [] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int index = indexOf.apply(arr);
        System.out.println(index);
    }
}
