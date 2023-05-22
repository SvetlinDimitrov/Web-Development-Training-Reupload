package JavaAdvance.Lab_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Compare_Matrices_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix1 = MatrixWork(scanner);
        int[][] matrix2 = MatrixWork(scanner);
        if (IsEqual(matrix1, matrix2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean IsEqual(int[][] matrix1, int[][] matrix11) {
        if (matrix1.length == matrix11.length) {
            if (matrix1[0].length == matrix11[0].length) {
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix1[i].length; j++) {
                        if (matrix1[i][j] != matrix11[i][j]) {
                            return false;
                        }
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }



    private static int[][] MatrixWork(Scanner scanner) {
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i]= Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
