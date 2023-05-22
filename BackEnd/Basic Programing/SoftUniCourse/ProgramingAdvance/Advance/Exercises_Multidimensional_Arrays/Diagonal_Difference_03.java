package JavaAdvance.Exercises_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Diagonal_Difference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeMatrix = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[sizeMatrix][sizeMatrix];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i]= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
        }
        int sumPrimaryDiagonal = Primary(matrix);
        int sumSecondDiagonal = extracted(matrix);
        System.out.println(Math.abs(sumPrimaryDiagonal-sumSecondDiagonal));
    }

    private static int extracted(int[][] matrix) {
        int sumSecondDiagonal=0;
        for (int i = 0; i < matrix.length; i++) {
            sumSecondDiagonal += matrix[i][matrix.length-1-i];
        }
        return sumSecondDiagonal;
    }

    private static int Primary(int[][] matrix) {
        int sumPrimaryDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i==j){
                    sumPrimaryDiagonal += matrix[i][j];
                    break;
                }
            }
        }
        return sumPrimaryDiagonal;
    }
}
