package JavaAdvance.Functional_Programming_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Count_Uppercase_Words_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> predicate = word -> Character.isUpperCase(word.charAt(0));

        List<String> words = Arrays.stream(scanner.nextLine().split(" "))
                .filter(predicate)
                .collect(Collectors.toList());
        Function<List<String> , Integer> count = List::size;

        System.out.println(count.apply(words));
        words.forEach(System.out::println);

    }
}
