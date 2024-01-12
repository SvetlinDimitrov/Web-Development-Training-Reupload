package JavaAdvance.Functional_Programming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Count_Uppercase_Words_03_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Object[] words = Arrays.stream(scanner.nextLine().split(" "))
                .filter(e->Character.isUpperCase(e.charAt(0)))
                .toArray();
        System.out.println(words.length);
        Arrays.stream(words).forEach(System.out::println);

    }
}
