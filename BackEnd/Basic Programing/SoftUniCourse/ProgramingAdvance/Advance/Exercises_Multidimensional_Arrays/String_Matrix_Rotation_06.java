package JavaAdvance.Exercises_Multidimensional_Arrays;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class String_Matrix_Rotation_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayList<String> words = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            words.add(input);
            input = scanner.nextLine();
        }

        int row = words.size();
        int cloe = LongerstWord(words);
        Character[][] matrix = new Character[row][cloe];
        matrix = MatrixFill(matrix, words);

        int gradus = Integer.parseInt(command.split("[()]")[1]);
        int times = gradus %360 ;
        Character [][] matrixToPint = new Character [cloe][row];
        Character [][] matrixToPint2 = new Character [row][cloe];
        switch (times){
            case 90:
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrixToPint[j][i] = matrix[matrix.length-1-i][j];
                    }
                }
                PintMatrix(matrixToPint);
                break;
            case 180 :
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrixToPint2[i][matrixToPint2[i].length-1-j] = matrix[matrix.length-1-i][j];
                    }
                }
                PintMatrix(matrixToPint2);
                break;
            case 270:
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrixToPint[matrixToPint2[0].length-1-j][i] = matrix[i][j];
                    }
                }
                PintMatrix(matrixToPint);
                break;
            case 0:
                PintMatrix(matrix);
                break;
        }
    }

    private static void PintMatrix(Character[][] matrixToPint) {
        for (Character[] characters : matrixToPint) {
            for (Character character : characters) {
                System.out.printf("%c",character);
            }
            System.out.println();
        }
    }

    private static Character[][] MatrixFill(Character[][] matrix, ArrayList<String> words) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i].length > words.get(i).length()) {
                    if(j < words.get(i).length()){
                        matrix[i][j] = words.get(i).charAt(j);
                    }else{
                        matrix[i][j] = ' ';
                    }
                } else {
                    matrix[i][j] = words.get(i).charAt(j);
                }
            }
        }
        return matrix;
    }

    private static int LongerstWord(ArrayList<String> words) {
        int maxSum = 0;
        for (String word : words) {
            if (word.length() > maxSum) {
                maxSum = word.length();
            }
        }
        return maxSum;
    }
}
