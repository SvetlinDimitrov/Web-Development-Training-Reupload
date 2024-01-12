package JavaAdvance.Lab_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Sum_Matrix_Elements_04_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] elements1 = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = elements1[0];
        int cloe = elements1[1];
        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).sum();
        }
        System.out.println(row);
        System.out.println(cloe);
        System.out.println(sum);
    }
}
