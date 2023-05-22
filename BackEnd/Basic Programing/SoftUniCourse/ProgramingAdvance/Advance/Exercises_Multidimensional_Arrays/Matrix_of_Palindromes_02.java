package JavaAdvance.Exercises_Multidimensional_Arrays;

import java.util.Scanner;

public class Matrix_of_Palindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int row = Integer.parseInt(input.split(" ")[0]);
        int cloe = Integer.parseInt(input.split(" ")[1]);
        String [][] matrix = new String [row][cloe];
        char letter = 'a';
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = String.format("%c%c%c",letter , letter+j , letter);
            }
            letter+=1;
        }
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.printf("%s ",string);
            }
            System.out.println();
        }
    }
}
