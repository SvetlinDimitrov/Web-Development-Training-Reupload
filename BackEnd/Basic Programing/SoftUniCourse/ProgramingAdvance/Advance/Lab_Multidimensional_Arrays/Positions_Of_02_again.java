package JavaAdvance.Lab_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Positions_Of_02_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] elements = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int [][]matrix = new int [elements[0]][elements[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
            int findNum = Integer.parseInt(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(findNum== matrix[i][j]){
                    System.out.printf("%d %d%n",i,j);
                    count++;
                }
            }
        }
        if (count ==0){
            System.out.println("not found");
        }
    }
}
