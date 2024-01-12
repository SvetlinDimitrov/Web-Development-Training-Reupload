package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Custom_Min_Function_03_Again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> Min = arr-> {
            final int[] x = {Integer.MAX_VALUE};
            Arrays.stream(arr).forEach(e->{
                if( e < x[0]){
                    x[0] =e;
                }
            });
return x[0];
        };


        System.out.println(Min.apply(nums));
    }
}
