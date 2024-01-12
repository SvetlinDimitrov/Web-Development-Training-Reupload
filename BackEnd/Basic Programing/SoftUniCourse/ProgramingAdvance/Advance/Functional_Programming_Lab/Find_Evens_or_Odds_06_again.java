package JavaAdvance.Functional_Programming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Find_Evens_or_Odds_06_again {
    public static String words;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int num1 = Integer.parseInt(input.split(" ")[0]);
        int num2 = Integer.parseInt(input.split(" ")[1]);
        String condition = scanner.nextLine();

        words = String.format("%d ",num1);
        for (int i = num1+1; i <= num2; i++) {
            words += (String.format("%d ", i));
        }

        int[] nums = Arrays.stream(words.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Predicate<String> conditionString = x-> x.equals("odd");
        Predicate<Integer> odd = y -> y % 2 != 0;
        Predicate<Integer> even = x -> x % 2 == 0;

        if (conditionString.test(condition)) {
            Arrays.stream(nums)
                    .boxed()
                    .filter(odd)
                    .forEach(e-> System.out.printf("%d ",e));
        } else {
            Arrays.stream(nums)
                    .boxed()
                    .filter(even)
                    .forEach(e-> System.out.printf("%d ",e));
        }
    }
}
