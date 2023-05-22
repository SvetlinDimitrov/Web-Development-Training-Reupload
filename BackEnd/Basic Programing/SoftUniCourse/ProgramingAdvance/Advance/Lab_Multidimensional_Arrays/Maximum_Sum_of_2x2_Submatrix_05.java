package JavaAdvance.Lab_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Maximum_Sum_of_2x2_Submatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(", ")[0]);
        int cols = Integer.parseInt(input.split(", ")[1]);
        int [][]matrix = new int [rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int sum = Integer.MIN_VALUE;
        String num = "";
        String coordinates = " ";
        int ultSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= matrix[i].length/2; j+=2) {
                if(sum < matrix[i][j] + matrix[i][j+1]){
                    sum = matrix[i][j] + matrix[i][j+1];
                    num = String.format("%d %d" ,matrix[i][j],matrix[i][j+1]);
                    coordinates = String.format("%s %s %s %s",i , j , i ,j+1);
                }
            }
        }

        System.out.println(num);
        ultSum+=sum;

        int rowFirstNum = Integer.parseInt(coordinates.split(" ")[0]);
        int cloeFirstNum = Integer.parseInt(coordinates.split(" ")[1]);
        int rowSecondNum = Integer.parseInt(coordinates.split(" ")[2]);
        int cloeSecondNum = Integer.parseInt(coordinates.split(" ")[3]);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i==rowFirstNum && j==cloeFirstNum || i==rowSecondNum && j==cloeSecondNum){
                    matrix[i][j]=0;
                }
            }
        }
        sum = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= matrix[i].length/2; j+=2) {
                if(sum < matrix[i][j] + matrix[i][j+1]){
                    sum = matrix[i][j] + matrix[i][j+1];
                    num = String.format("%d %d" ,matrix[i][j],matrix[i][j+1]);
                    coordinates = String.format("%s %s %s %s",i , j , i ,j+1);
                }
            }
        }
        System.out.println(num);
        ultSum+=sum;
        System.out.println(ultSum);
    }
}
