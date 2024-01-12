package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Knights_of_Honor_02_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] names = scanner.nextLine().split("\\s+");
        Consumer<String> printSir = e->System.out.printf("Sir %s%n",e);
        Arrays.stream(names).forEach(printSir);
    }
}
