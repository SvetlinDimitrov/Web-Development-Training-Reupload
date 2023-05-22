package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Find_The_Smallest_Element_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> yes = cat -> {
            int smallestNum = Integer.MAX_VALUE;
            for (Integer num : cat) {
                if (num < smallestNum) {
                    smallestNum = num;
                }
            }
            return smallestNum;
        };
        System.out.println(list.indexOf(yes.apply(list)));
    }
}
