package JavaAdvance.Functional_Programming_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Add_VAT_04_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double [] prices = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .map(e->e*1.2)
                .toArray();
        System.out.println("Prices with VAT:");
        Arrays.stream(prices).forEach(e->System.out.printf("%.2f%n",e));
    }
}
