package JavaAdvance.Exams.Java_Advanced_Retake_Exam14April2021;

import java.util.Scanner;

public class Cooking_journey_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n =Integer.parseInt(scanner.nextLine());
        char [][] matrix =  new char [n][n];
        int myRow = -1;
        int myCloe =- 1;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                if(myRow != -1 && myCloe !=- 1){
                    break;
                }else if(matrix[i][j] == 'S'){
                    myRow = i;
                    myCloe = j;
                }
            }
        }
        int priceCollected =0;
        while (true){
            String command = scanner.nextLine();

            matrix[myRow][myCloe] = '-';
            if(command.equals("up")){
                myRow--;
            }else if(command.equals("down")){
                myRow++;
            }else if (command.equals("left")){
                myCloe--;
            }else if (command.equals("right")){
                myCloe++;
            }
            if(!IsMatrixValid(myRow,myCloe,matrix)){
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            } else if(Character.isDigit(matrix[myRow][myCloe])){
                priceCollected += Integer.parseInt(String.valueOf(matrix[myRow][myCloe]));
            }else if (matrix[myRow][myCloe] == 'P'){
                matrix[myRow][myCloe] = '-';
                int [] secondPillar = FindSecondPillar(matrix);
                myRow = secondPillar[0];
                myCloe = secondPillar[1];
            }
            matrix[myRow][myCloe] = 'S';
            if (priceCollected >= 50){
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
        }

        System.out.printf("Money: %d%n",priceCollected);

        for (char[] row : matrix) {
            for (char c : row) {
                System.out.printf("%c",c);
            }
            System.out.println();
        }
    }

    private static boolean IsMatrixValid(int myRow, int myCloe, char[][] matrix) {
        return myRow <= matrix.length-1 && myRow >= 0
                && myCloe <= matrix[0].length-1 && myCloe >= 0;
    }

    private static int[] FindSecondPillar(char[][] matrix) {
        int [] toReturn = new int [2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 'P'){
                    toReturn[0]=i;
                    toReturn[1]=j;
                    return toReturn;
                }
            }
        }
        return toReturn;
    }
}
