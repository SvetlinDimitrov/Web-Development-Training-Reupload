package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Custom_Min_Function_03_again_list {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer> , Integer> min = list ->{
            Integer minValue = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                if(minValue>list.get(i)){
                    minValue = list.get(i);
                }
            }
            return minValue;
        };

        System.out.println(min.apply(nums));
    }
}
