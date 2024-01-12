package JavaAdvance.Functional_Programming_Lab;

import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sum_Numbers_02_Again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] nums = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[] , String> count = (x)-> String.format("Count = %d",x.length);
        System.out.println(count.apply(nums));
        System.out.printf("Sum = %d",Arrays.stream(nums).sum());
    }
}
