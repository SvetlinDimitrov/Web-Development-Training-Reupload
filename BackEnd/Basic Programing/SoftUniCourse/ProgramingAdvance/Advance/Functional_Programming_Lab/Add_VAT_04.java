package JavaAdvance.Functional_Programming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Add_VAT_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> vat = e -> e*1.2;

        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(vat)
                .forEach(e -> System.out.printf("%.2f%n",e));

                
    }
}
