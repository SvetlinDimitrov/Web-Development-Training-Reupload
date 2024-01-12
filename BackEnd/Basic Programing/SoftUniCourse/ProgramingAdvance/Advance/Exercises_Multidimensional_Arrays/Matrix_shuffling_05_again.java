package JavaAdvance.Exercises_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix_shuffling_05_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int [] matrixInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String [][] matrix = new String [matrixInput[0]][matrixInput[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }


        String [] input = scanner.nextLine().split(" ");
        while(!input[0].equals("END")){
            if (input[0].equals("swap") && input.length == 5){
                int r1 = Integer.parseInt(input[1]);
                int c1 = Integer.parseInt(input[2]);
                int r2 = Integer.parseInt(input[3]);
                int c2 = Integer.parseInt(input[4]);
                if(Valid(matrix , r1,c1,r2,c2)){
                    String save = matrix[r1][c1];
                    matrix[r1][c1] = matrix[r2][c2];
                    matrix[r2][c2] = save;
                    Print(matrix);
                }else{
                    System.out.println("Invalid input!");
                }
            }else{
                System.out.println("Invalid input!");
            }
            input= scanner.nextLine().split(" ");
        }
    }

    private static void Print(String[][] input) {
        for (String arr[] : input) {
            for (String s1 : arr) {
                System.out.printf("%s ",s1);
            }
            System.out.println();
        }
    }

    private static boolean Valid(String[][] matrix, int r1, int c1, int r2, int c2) {
        return matrix.length-1 >=r1 && matrix.length-1 >=r2 && r1>=0 && r2>=0 &&
                matrix[r1].length-1 >= c1 && matrix[r2].length-1 >= c2 && c1 >=0 && c2 >=0;
    }
}
