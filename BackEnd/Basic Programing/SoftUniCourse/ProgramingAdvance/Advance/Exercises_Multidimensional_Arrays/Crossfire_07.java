package JavaAdvance.Exercises_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Crossfire_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int row = Integer.parseInt(input.split(" ")[0]);
        int cloe = Integer.parseInt(input.split(" ")[1]);
        String [][] matrix = new String [row][cloe];
        FillMatrix(matrix);

        String secondInput = scanner.nextLine();
        while(!secondInput.equals("Nuke it from orbit")){
            int rowCheck = Integer.parseInt(secondInput.split(" ")[0]);
            int cloeCheck = Integer.parseInt(secondInput.split(" ")[1]);
            int radius = Integer.parseInt(secondInput.split(" ")[2]);
            int counterLeftRow = 1;
            int counterRightRow = 1;
            int counterCloeUp =1 ;
            int counterCloeDown =1 ;
            boolean forEnd = true;
            if(validCloeAndRow(matrix,rowCheck,cloeCheck)){
                matrix[rowCheck][cloeCheck] = " ";
                while(forEnd) {
                    if (validCloeAndRow(matrix, rowCheck + counterLeftRow, cloeCheck) && counterLeftRow <= radius) {
                        matrix[rowCheck + counterLeftRow][cloeCheck] =  " ";
                        counterLeftRow++;
                    }else if (validCloeAndRow(matrix, rowCheck - counterRightRow, cloeCheck) && counterRightRow <= radius) {
                        matrix[rowCheck - counterRightRow][cloeCheck] =  " ";
                        counterRightRow++;
                    }else if (validCloeAndRow(matrix, rowCheck , cloeCheck - counterCloeUp) && counterCloeUp <= radius) {
                        matrix[rowCheck][cloeCheck-counterCloeUp] = " ";
                        counterCloeUp++;
                    }else if (validCloeAndRow(matrix, rowCheck , cloeCheck + counterCloeDown) && counterCloeDown <= radius) {
                        matrix[rowCheck][cloeCheck+counterCloeDown] = " ";
                        counterCloeDown++;
                    }else {
                        forEnd = false;
                    }
                }
                String [][] copyMatrix = new String [row][cloe];
                EmptyMatrix(matrix, copyMatrix);
                matrix=copyMatrix;
            }
            secondInput = scanner.nextLine();
        }

        PrintMatrix(matrix);
    }

    private static void EmptyMatrix(String[][] matrix, String[][] copyMatrix) {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(copyMatrix , " ");
            int cloeCount = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (!matrix[i][j].equals(" ")) {
                    copyMatrix[i][j-cloeCount] = matrix[i][j];
                }else{
                    cloeCount++;
                }
            }
        }
    }

    private static void FillMatrix(String[][] matrix) {
        int counter = 1 ;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = counter + "";
                counter++;
            }
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

    private static boolean validCloeAndRow(String[][] matrix, int rowCheck, int cloeCheck) {
        return matrix.length>rowCheck && rowCheck>=0 && matrix[0].length > cloeCheck && cloeCheck>= 0
                && !matrix[rowCheck][cloeCheck].equals(" ")  ;
    }
}
