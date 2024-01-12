package JavaAdvance.Lab_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Print_Diagonals_of_Square_Matrix_06_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cloeRow = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int [cloeRow][cloeRow];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%d ",matrix[i][i]);
        }
        System.out.println();
        int count = 0;
        for (int i = matrix.length -1 ; i >= 0; i--) {
            System.out.printf("%d ",matrix[i][count]);
            count++;
        }

    }
}
