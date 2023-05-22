package JavaAdvance.Lab_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Sum_Matrix_Elements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(", ")[0]);
        int cols = Integer.parseInt(input.split(", ")[1]);
        int [][] matrix = new int [rows][cols];
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum+=matrix[i][j];

            }
        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);

    }
}
