package JavaAdvance.Exercises_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Maximal_Sum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int row = Integer.parseInt(input.split(" ")[0]);
        int cloe = Integer.parseInt(input.split(" ")[1]);
        int[][] matrix = new int[row][cloe];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int[][] slideMatrix = new int[3][3];
        int sumMax = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] +
                        matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (sum > sumMax) {
                    sumMax = sum;
                    slideMatrix = new int[][]{{matrix[i][j], matrix[i][j + 1], matrix[i][j + 2]},
                            {matrix[i + 1][j], matrix[i + 1][j + 1], matrix[i + 1][j + 2]},
                            {matrix[i + 2][j], matrix[i + 2][j + 1], matrix[i + 2][j + 2]}
                    };
                }

            }
        }
        System.out.printf("Sum = %d%n",sumMax);
        for (int[] ints : slideMatrix) {
            for (int anInt : ints) {
                System.out.printf("%d ",anInt);
            }
            System.out.println();
        }
    }
}
