package JavaAdvance.Exercises_Multidimensional_Arrays;

import java.util.Scanner;

public class Fill_the_Matrix_01_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] commands = scanner.nextLine().split(", ");
        int rowCloe = Integer.parseInt(commands[0]);
        int [][] matrix = new int[rowCloe][rowCloe];
        int counter = 1;
        if(commands[1].equals("A")) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[j][i] = counter;
                    counter++;
                }

            }
        }else{
            for (int i = 0; i < matrix.length; i++) {
                if(i % 2 ==0) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrix[j][i] = counter;
                        counter++;
                    }
                }else{
                    for (int j = matrix[i].length-1 ; j >= 0; j--) {
                        matrix[j][i] = counter;
                        counter++;
                    }
                }
            }
        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%d ",anInt);
            }
            System.out.println();
        }
    }
}
