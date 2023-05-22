package JavaAdvance.Exercises_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Maximal_Sum_04_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int [][] matrix = new int[input[0]][input[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        String save = "";
        int maxSum =Integer.MIN_VALUE;
        int sum ;
        for (int i = 0; i < matrix.length-2; i++) {
            for (int j = 0; j < matrix[i].length-2; j++) {
                sum = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] +
                        matrix[i+1][j] + matrix[i+1][j+1] + matrix[i+1][j+2] +
                        matrix[i+2][j] + matrix[i+2][j+1] + matrix[i+2][j+2] ;
                if(maxSum < sum){
                    maxSum=sum;
                    save = String.format("%d %d %d%n%d %d %d%n%d %d %d",matrix[i][j],matrix[i][j+1],matrix[i][j+2]
                            ,matrix[i+1][j],matrix[i+1][j+1],matrix[i+1][j+2]
                            ,matrix[i+2][j],matrix[i+2][j+1],matrix[i+2][j+2]);
                }
            }
        }
        System.out.println("Sum = "+ maxSum);
        System.out.println(save);
    }
}
