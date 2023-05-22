package JavaAdvance.Exams.Java_Advanced_Exam22October2022;

import java.util.Arrays;
import java.util.Scanner;

public class Rally_Racing_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String car = scanner.nextLine();
        char [][] matrix = new char [n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().replaceAll("\\s+","").toCharArray();
        }
        int sumKm =0;
        int row=0;
        int cloe =0;
        matrix[row][cloe] = 'C';
        String command = scanner.nextLine();
        while(!command.equals("End")){
            matrix[row][cloe] = '.';
            switch (command){
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case"left":
                    cloe--;
                    break;
                case"right":
                    cloe++;
                    break;
            }

            if(matrix[row][cloe]== 'T'){
                matrix[row][cloe] = '.';
                sumKm+=30;
                int [] newCor = OtherT(matrix);
                row = newCor[0];
                cloe = newCor[1];
                matrix[row][cloe] = 'C';
            }else if(matrix[row][cloe] == 'F'){
                sumKm+=10;
                matrix[row][cloe] ='C';
                System.out.printf("Racing car %s finished the stage!%n",car);
                System.out.printf("Distance covered %d km.%n",sumKm);
                printMatrix(matrix);
                return;
            }else{
                sumKm+=10;
                matrix[row][cloe] = 'C';
            }
            command = scanner.nextLine();
        }
        System.out.printf("Racing car %s DNF.%n",car);
        System.out.printf("Distance covered %d km.%n",sumKm);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.printf("%c",aChar);
            }
            System.out.println();
        }
    }

    private static int[] OtherT(char[][] matrix) {
        int [] returnNew = new int [2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 'T'){
                    returnNew[0]=i;
                    returnNew[1] =j;
                    return returnNew;
                }
            }
        }
        return returnNew;
    }
}
