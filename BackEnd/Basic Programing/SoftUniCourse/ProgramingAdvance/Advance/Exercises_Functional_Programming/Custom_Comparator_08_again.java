package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Custom_Comparator_08_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.stream(input).filter(e->e%2 ==0)
                .sorted()
                .forEach(e->System.out.printf("%d ",e));

        Arrays.stream(input).filter(e->e%2 !=0)
                .sorted()
                .forEach(e->System.out.printf("%d ",e));
    }
}
