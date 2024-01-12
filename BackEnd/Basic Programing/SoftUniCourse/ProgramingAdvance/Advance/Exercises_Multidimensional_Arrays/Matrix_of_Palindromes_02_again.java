package JavaAdvance.Exercises_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix_of_Palindromes_02_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 97;
        int [] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String [][] matrix = new String [input[0]][input[1]];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = String.format("%c%c%c",counter ,counter+j,counter);
            }
            counter++;
        }
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.printf("%s ",string);
            }
            System.out.println();
        }
    }
}
