package JavaAdvance.Exercises_Functional_Programming;

import java.util.*;
import java.util.stream.Collectors;

public class Reverse_And_Exclude_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        numbers = numbers.stream().filter(e-> e%n != 0)
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        numbers.forEach(num -> System.out.printf("%d ",num));


    }
}
