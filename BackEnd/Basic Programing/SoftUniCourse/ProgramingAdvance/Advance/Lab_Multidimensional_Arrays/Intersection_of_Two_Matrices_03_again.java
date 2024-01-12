package JavaAdvance.Lab_Multidimensional_Arrays;

import java.util.Scanner;

public class Intersection_of_Two_Matrices_03_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int cloe = Integer.parseInt(scanner.nextLine());

        char [][] matrix1 = new char[row][cloe];
        char [][] matrix2 = new char[row][cloe];

        FillMatrix(scanner , matrix1 , row);
        FillMatrix(scanner , matrix2 , row);

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                if(matrix1[i][j] != matrix2[i][j]){
                    matrix1[i][j] = '*';
                }
            }
        }
        for (char[] chars : matrix1) {
            for (char aChar : chars) {
                System.out.printf("%c",aChar);
            }
            System.out.println();
        }
    }
    public static void FillMatrix(Scanner scanner , char [][] matrix , int row ){
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
    }
}
