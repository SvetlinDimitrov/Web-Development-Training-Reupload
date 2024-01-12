package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Predicate_For_Names_06_again {
    public static int num;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        num=Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> condition = e->e.length() <= num;

        Arrays.stream(names).filter(condition)
                .forEach(e->System.out.println(e));
    }
}
