package JavaAdvance.Exams.Java_Advanced_Retake_Exam15December2021;

import java.util.Scanner;

public class Throne_Conquering_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hp = Integer.parseInt(scanner.nextLine());
        int [] helen = new int [2];
        int [] paris = new int [2];


        int n = Integer.parseInt(scanner.nextLine());
        char [][] matrix = new char [n][n];


        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 'H' ){
                    helen[0] = i;
                    helen[1] = j;
                }
                if(matrix[i][j] == 'P' ){
                    paris[0] = i;
                    paris[1] = j;
                }
            }
        }

        while(true){

            String [] commands = scanner.nextLine().split(" ");
            String move = commands[0];
            int rowToMove = Integer.parseInt(commands[1]);
            int cloeToMove = Integer.parseInt(commands[2]);
                matrix[rowToMove][cloeToMove] = 'S';

                matrix[paris[0]][paris[1]] = '-';
            if(move.equals("up") && paris[0] !=0){
                paris[0]--;
            }else if (move.equals("down") && paris[0] != matrix.length-1){
                paris[0]++;
            }else if (move.equals("left") && paris[1] !=0){
                paris[1]--;
            }else if (move.equals("right") && paris[1] != matrix.length-1) {
                paris[1]++;
            }


                if(matrix[paris[0]][paris[1]] == 'S'){
                    hp-=2;
                }
                matrix[paris[0]][paris[1]] = 'P';
            hp--;
            if(paris[0] == helen[0] && paris[1] == helen[1]){
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n",hp);
                matrix[paris[0]][paris[1]] = '-';
                break;
            }
            if(hp <= 0){
                matrix[paris[0]][paris[1]] = 'X';
                System.out.printf("Paris died at %d;%d.%n",paris[0],paris[1]);
                break;
            }
        }
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.printf("%c",aChar);
            }
            System.out.println();
        }
    }
}
