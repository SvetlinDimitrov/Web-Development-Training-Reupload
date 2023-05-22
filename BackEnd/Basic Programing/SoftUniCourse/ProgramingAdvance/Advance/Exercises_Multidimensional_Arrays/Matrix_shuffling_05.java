package JavaAdvance.Exercises_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix_shuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int row = Integer.parseInt(input.split(" ")[0]);
        int cloe = Integer.parseInt(input.split(" ")[1]);
        String [][] matrix = new String [row][cloe];

        for (int i = 0; i <matrix.length ; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        String secondInput = scanner.nextLine();
        while(!secondInput.split(" ")[0].equals("END")){
            if(secondInput.split(" ")[0].equals("swap")){
                int row1 = Integer.parseInt(secondInput.split(" ")[1]);
                int cloe1 = Integer.parseInt(secondInput.split(" ")[2]);
                int row2 = Integer.parseInt(secondInput.split(" ")[3]);
                int cloe2 = Integer.parseInt(secondInput.split(" ")[4]);

                if(VadildIndex(row1 , cloe1 , row2,cloe2,matrix)){
                    String save = matrix[row1][cloe1];
                    matrix[row1][cloe1] = matrix[row2][cloe2];
                    matrix[row2][cloe2] = save;
                    PrintMatrix(matrix);
                }else{
                    System.out.println("Invalid input!");
                }
            }else{
                System.out.println("Invalid input!");
            }
            secondInput = scanner.nextLine();
        }
    }

    private static void PrintMatrix(String[][] matrix) {
        for (String[] ints : matrix) {
            for (String anInt : ints) {
                System.out.printf("%s ",anInt);
            }
            System.out.println();
        }
    }

    private static boolean VadildIndex(int row1, int cloe1, int row2, int cloe2, String[][] matrix) {
        return matrix.length>row1 && row1>=0 && matrix.length>row2 && row2>=0
                && matrix[0].length > cloe1 && cloe1>= 0 && matrix[0].length > cloe2 && cloe2>= 0;
    }
}
