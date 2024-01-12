package JavaAdvance.Exams.Java_Advanced_Exam26June2021;

import java.util.Arrays;
import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String [] moves = scanner.nextLine().split(", ");
        int allFoodCount = 0;

        char[][]matrix = new char [n][n];
        int row = -1;
        int cloe = -1 ;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().replaceAll(" " , "").toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 'f'){
                    allFoodCount++;
                }
                if(matrix[i][j] == 's'){
                    row = i;
                    cloe =j;

                }
            }
        }
        int foodEaten =0;
        for (String move : moves) {
            matrix[row][cloe] = '*';
            switch (move){
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    cloe--;
                    break;
                case "right":
                    cloe++;
                    break;
            }
            if(!snakeIsOut(row ,cloe ,matrix)){
                switch (move){
                    case "up":
                        row = matrix.length-1;
                        break;
                    case "down":
                        row = 0;
                        break;
                    case "left":
                        cloe = matrix[0].length -1;
                        break;
                    case "right":
                        cloe = 0;
                        break;
                }
            }
            if (matrix[row][cloe] == 'e'){
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
            if (matrix[row][cloe] == 'f'){
                foodEaten++;
            }
            matrix[row][cloe] = 's';

        }
        if(foodEaten == allFoodCount){
            System.out.printf("You win! Final python length is %d",foodEaten+1);
        }else {
            System.out.printf("You lose! There is still %d food to be eaten.",allFoodCount-foodEaten);
        }


    }

    private static boolean snakeIsOut(int row, int cloe, char[][] matrix) {
        return row >= 0 && row <= matrix.length-1
                && cloe >= 0 && cloe <= matrix.length-1;
    }
}
