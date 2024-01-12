package JavaAdvance.Lab_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Intersection_of_Two_Matrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        String [][] matrix1 = CreateYourOwnMatrix(rows ,cols , scanner);
        String [][] matrix2 = CreateYourOwnMatrix(rows ,cols , scanner);

        AnswerPrintMatrix(matrix1 , matrix2);
    }

    private static void AnswerPrintMatrix(String[][] matrix1, String[][] matrix2) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                if(matrix1[i][j].equals(matrix2[i][j])){
                    System.out.printf("%s ",matrix1[i][j]);
                }else{
                    System.out.printf("%s ","*");
                }
            }
            System.out.println();
        }
    }

    private static String[][] CreateYourOwnMatrix(int rows, int cols, Scanner scanner) {
        String [][] matrix = new String [rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        return matrix;
    }
}
