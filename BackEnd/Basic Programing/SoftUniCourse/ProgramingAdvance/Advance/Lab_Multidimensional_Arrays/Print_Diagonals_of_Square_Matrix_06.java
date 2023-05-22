package JavaAdvance.Lab_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Print_Diagonals_of_Square_Matrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == i) {
                    System.out.printf("%d ", matrix[i][j]);
                    break;
                }
            }
        }
        System.out.println();
        int count = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (count == 0) {
                    if (i == matrix.length - 1 && j == 0) {
                        count++;
                        System.out.printf("%d ", matrix[i][j]);
                        break;
                    }
                } else {
                    if (i == matrix.length - 1 - count && j == count) {
                        count++;
                        System.out.printf("%d ", matrix[i][j]);
                        break;
                    }
                }
            }
        }
    }
}
