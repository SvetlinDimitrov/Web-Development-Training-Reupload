package JavaAdvance.Exams.Java_Advanced_Retake_Exam18August2021;

import java.util.Scanner;

public class Formula_One_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char [][] matrix = new char [n][n];
        int time = Integer.parseInt(scanner.nextLine());



        int rowPlayer = -1;
        int cloePLayer = -1;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] =='P'){
                    rowPlayer=i;
                    cloePLayer=j;
                }
                if(rowPlayer != -1 && cloePLayer != -1){
                    break;
                }
            }
        }
        boolean weWon = false;

        String command = scanner.nextLine();
        while(time != 0) {

            if(matrix[rowPlayer][cloePLayer] != 'B') {
                matrix[rowPlayer][cloePLayer] = '.';

            }
            switch (command){
                case"up":
                    rowPlayer--;
                    break;
                case "down":
                    rowPlayer++;
                    break;
                case "left":
                    cloePLayer--;
                    break;
                case "right":
                    cloePLayer++;
                    break;
            }
            if(!indexValid(rowPlayer , cloePLayer , matrix)){
                if(rowPlayer == -1){
                    rowPlayer = matrix.length-1;
                }else if (rowPlayer == matrix.length){
                    rowPlayer =0;
                }else if (cloePLayer == -1){
                    cloePLayer = matrix[0].length-1;
                }else if (cloePLayer == matrix[0].length){
                    cloePLayer=0;
                }
            }else if (matrix[rowPlayer][cloePLayer] == 'B'){
                continue;
            }else if (matrix[rowPlayer][cloePLayer] == 'T'){
                switch (command){
                    case"up":
                        rowPlayer++;
                        break;
                    case "down":
                        rowPlayer--;
                        break;
                    case "left":
                        cloePLayer++;
                        break;
                    case "right":
                        cloePLayer--;
                        break;
                }
            }else if (matrix[rowPlayer][cloePLayer] == 'F'){
                weWon = true;
            }
            matrix[rowPlayer][cloePLayer] = 'P';

            if(weWon) {
                System.out.println("Well done, the player won first place!");
                break;
            }

            if(matrix[rowPlayer][cloePLayer] != 'B'){
                time--;
                if(time == 0){
                    break;
                }
                command = scanner.nextLine();
            }
        }
        if(!weWon){
            System.out.println("Oh no, the player got lost on the track!");
        }
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.printf("%c",aChar);
            }
            System.out.println();
        }

    }

    private static boolean indexValid(int rowPlayer, int cloePLayer, char[][] matrix) {
        return rowPlayer <= matrix.length-1 && rowPlayer>=0
                && cloePLayer <= matrix[0].length-1 && cloePLayer >= 0;
    }
}
