package JavaAdvance.Lab_Multidimensional_Arrays;

import javax.xml.transform.SourceLocator;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class Compare_Matrices_01_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] elements1 = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = elements1[0];
        int cloe = elements1[1];
        int [][] matrix1 = new int[row][cloe];

        CreateMatrix(scanner, row, matrix1);

        elements1 = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        row = elements1[0];
        cloe = elements1[1];
        int [][] matrix2 = new int[row][cloe];

        CreateMatrix(scanner , row , matrix2);

        System.out.println(Print(matrix1, matrix2));
    }

    private static String Print(int[][] matrix1, int[][] matrix2) {
        if(matrix1.length == matrix2.length){
            if(matrix1[0].length == matrix2[0].length){
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix1[i].length; j++) {
                        if(matrix1[i][j] != matrix2[i][j]){
                            return "not equal";
                        }
                    }
                }
            }else{
                return "not equal";
            }
        }else{
            return "not equal";
        }
        return "equal";
    }

    private static void CreateMatrix(Scanner scanner, int row, int[][] matrix) {
        for (int i = 0; i < row; i++) {
            matrix[i]=Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
