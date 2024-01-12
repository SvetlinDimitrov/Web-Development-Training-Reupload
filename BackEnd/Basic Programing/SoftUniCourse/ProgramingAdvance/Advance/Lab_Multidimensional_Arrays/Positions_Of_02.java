package JavaAdvance.Lab_Multidimensional_Arrays;

import java.util.Scanner;

public class Positions_Of_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int findNum = scanner.nextInt();

        System.out.println();
        if (isThereSomeone(matrix, findNum)) {
            PrintAllEaqualNum(findNum, matrix);
        } else {
            System.out.println("not found");
        }
    }

    private static boolean isThereSomeone(int[][] matrix, int findNum) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(findNum == matrix[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    private static void PrintAllEaqualNum(int findNum, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == findNum) {
                    System.out.printf("%d %d%n", i, j);
                }
            }

        }
    }
}
