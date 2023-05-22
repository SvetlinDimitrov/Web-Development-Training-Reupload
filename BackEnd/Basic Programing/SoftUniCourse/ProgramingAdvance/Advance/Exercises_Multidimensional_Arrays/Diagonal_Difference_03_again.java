package JavaAdvance.Exercises_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Diagonal_Difference_03_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int primaryDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            primaryDiagonal += matrix[i][i];
        }
        int secondaryDiagonal = 0;
        int count = 0;
        for (int i = matrix.length-1; i >= 0 ; i--) {
            secondaryDiagonal += matrix[i][count];
            count++;
        }
        System.out.println(Math.abs(primaryDiagonal-secondaryDiagonal));
    }
}
