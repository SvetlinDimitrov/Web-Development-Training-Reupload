package JavaAdvance.Exams.Java_Advanced_Retake_Exam13April2022;

import java.util.Scanner;

public class Armory_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];


        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }

        int startRow = 0;
        int startCloe = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("A")) {
                    startRow = i;
                    startCloe = j;
                    break;
                }
            }
        }
        String command = scanner.nextLine();
        int totalGold = 0;
        boolean end = false;
        while (!command.equals("End")) {

            switch (command) {
                case "up":
                    startRow--;
                    if (!ValidIndex(startRow, startCloe, matrix)) {
                        System.out.println("I do not need more swords!");
                        matrix[startRow + 1][startCloe] = "-";
                        end = true;
                        break;
                    } else if (IsSword(startRow, startCloe, matrix)) {
                        totalGold += Integer.parseInt(matrix[startRow][startCloe]);
                        matrix[startRow + 1][startCloe] = "-";
                        matrix[startRow][startCloe] = "A";
                        if (totalGold >= 65) {
                            System.out.println("Very nice swords, I will come back for more!");
                            end = true;
                            break;
                        }
                    } else if (matrix[startRow][startCloe].equals("M")) {
                        int [] newRowCloe = FindingMirrors(startRow ,startCloe ,matrix);
                        matrix[startRow + 1][startCloe] = "-";
                        matrix[startRow][startCloe] = "-";
                        startRow = newRowCloe[0];
                        startCloe = newRowCloe[1];
                        matrix[startRow][startCloe] = "A";
                    }else {
                        matrix[startRow + 1][startCloe] = "-";
                        matrix[startRow][startCloe] = "A";
                    }
                    break;
                case "down":
                    startRow++;
                    if (!ValidIndex(startRow, startCloe, matrix)) {
                        System.out.println("I do not need more swords!");
                        matrix[startRow - 1][startCloe] = "-";
                        end = true;
                        break;
                    } else if (IsSword(startRow, startCloe, matrix)) {
                        totalGold += Integer.parseInt(matrix[startRow][startCloe]);
                        matrix[startRow - 1][startCloe] = "-";
                        matrix[startRow][startCloe] = "A";
                        if (totalGold >= 65) {
                            System.out.println("Very nice swords, I will come back for more!");
                            end = true;
                            break;
                        }
                    } else if (matrix[startRow][startCloe].equals("M")) {
                        int [] newRowCloe = FindingMirrors(startRow ,startCloe ,matrix);
                        matrix[startRow - 1][startCloe] = "-";
                        matrix[startRow][startCloe] = "-";
                        startRow = newRowCloe[0];
                        startCloe = newRowCloe[1];
                        matrix[startRow][startCloe] = "A";
                    }else {
                        matrix[startRow - 1][startCloe] = "-";
                        matrix[startRow][startCloe] = "A";
                    }
                    break;
                case "left":
                    startCloe--;
                    if (!ValidIndex(startRow, startCloe, matrix)) {
                        System.out.println("I do not need more swords!");
                        matrix[startRow][startCloe+1] = "-";
                        end = true;
                        break;
                    } else if (IsSword(startRow, startCloe, matrix)) {
                        totalGold += Integer.parseInt(matrix[startRow][startCloe]);
                        matrix[startRow][startCloe+1] = "-";
                        matrix[startRow][startCloe] = "A";
                        if (totalGold >= 65) {
                            System.out.println("Very nice swords, I will come back for more!");
                            end = true;
                            break;
                        }
                    } else if (matrix[startRow][startCloe].equals("M")) {
                        int [] newRowCloe = FindingMirrors(startRow ,startCloe ,matrix);
                        matrix[startRow][startCloe+1] = "-";
                        matrix[startRow][startCloe] = "-";
                        startRow = newRowCloe[0];
                        startCloe = newRowCloe[1];
                        matrix[startRow][startCloe] = "A";
                    }else {
                        matrix[startRow][startCloe+1] = "-";
                        matrix[startRow][startCloe] = "A";
                    }
                    break;
                case "right":
                    startCloe++;
                    if (!ValidIndex(startRow, startCloe, matrix)) {
                        System.out.println("I do not need more swords!");
                        matrix[startRow][startCloe-1] = "-";
                        end = true;
                        break;
                    } else if (IsSword(startRow, startCloe, matrix)) {
                        totalGold += Integer.parseInt(matrix[startRow][startCloe]);
                        matrix[startRow][startCloe-1] = "-";
                        matrix[startRow][startCloe] = "A";
                        if (totalGold >= 65) {
                            System.out.println("Very nice swords, I will come back for more!");
                            end = true;
                            break;
                        }
                    } else if (matrix[startRow][startCloe].equals("M")) {
                        int [] newRowCloe = FindingMirrors(startRow ,startCloe ,matrix);
                        matrix[startRow][startCloe-1] = "-";
                        matrix[startRow][startCloe] = "-";
                        startRow = newRowCloe[0];
                        startCloe = newRowCloe[1];
                        matrix[startRow][startCloe] = "A";
                    }else {
                        matrix[startRow][startCloe-1] = "-";
                        matrix[startRow][startCloe] = "A";
                    }
                    break;
            }
            if(end){
                break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("The king paid %d gold coins.%n",totalGold);
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.printf("%s",string);
            }
            System.out.println();
        }
    }

    public static boolean ValidIndex(int row, int cloe, String[][] matrix) {
       return row <= matrix.length - 1 && row >= 0 && cloe >= 0 && cloe <= matrix[0].length - 1;
    }

    public static boolean IsSword(int row, int cloe, String[][] matrix) {
       return matrix[row][cloe].equals("9") || matrix[row][cloe].equals("8")
                || matrix[row][cloe].equals("7") || matrix[row][cloe].equals("6")
                || matrix[row][cloe].equals("5") || matrix[row][cloe].equals("4")
                || matrix[row][cloe].equals("3") || matrix[row][cloe].equals("2")
                || matrix[row][cloe].equals("1") || matrix[row][cloe].equals("0");
    }

    public static int[] FindingMirrors(int row , int cloe ,String[][] matrix){
        int [] arr = new int [2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].equals("M")){
                    boolean areTheyEquals = i == row && j == cloe;
                    if(!areTheyEquals){
                        arr[0] = i;
                        arr[1] = j;
                    }
                }
            }
        }
        return arr;
    }
}
