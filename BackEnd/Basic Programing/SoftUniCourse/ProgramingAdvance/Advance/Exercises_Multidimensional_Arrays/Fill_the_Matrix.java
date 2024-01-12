package JavaAdvance.Exercises_Multidimensional_Arrays;

import java.util.Scanner;

public class Fill_the_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(input[0]);
        String typeMatrix = input[1];
        int[][] matrix = new int[matrixSize][matrixSize];
        int count = 1;
        if (typeMatrix.equals("A")) {
            MethofAFill(matrix, count);
        } else {
            MethodBFill(matrix, count);
        }
        int printCount = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }

    private static void MethodBFill(int[][] matrix, int count) {
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[j][i] = count;
                    count++;
                }
            } else {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    matrix[j][i] = count;
                    count++;
                }
            }
        }
    }

    private static void MethofAFill(int[][] matrix, int count) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = count;
                count++;
            }
        }
    }
}
