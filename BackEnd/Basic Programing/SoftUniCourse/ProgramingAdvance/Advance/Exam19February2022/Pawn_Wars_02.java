package JavaAdvance.Exams.Java_Advanced_Exam19February2022;

import java.util.Scanner;

public class Pawn_Wars_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [][] matrix = new String [8][8];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }

        int rowWhite = 0;
        int cloeWhite = 0;
        boolean out = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].equals("w")){
                    rowWhite = i;
                    cloeWhite=j;
                    out = true;
                    break;
                }
            }
            if(out){
                break;
            }
        }


        int rowBlack = 0;
        int cloeBlack = 0;
        out = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].equals("b")){
                    rowBlack = i;
                    cloeBlack=j;
                    out = true;
                    break;
                }
            }
            if(out){
                break;
            }
        }

        System.out.println();

        while(true){


            rowWhite--;
            if(!outOfTheGame(rowWhite, cloeWhite,matrix)){
                System.out.printf("Game over! White pawn is promoted to a queen at %s.%n"
                        ,Cordinate("w",rowWhite+1,cloeWhite));
                return;
            }else if (cloeWhite == 0){
                if(matrix[rowWhite][cloeWhite+1].equals("b")){
                    System.out.printf("Game over! White capture on %s.%n"
                            ,Cordinate("w",rowWhite,cloeWhite+1));
                    return;
                }
            } else if (cloeWhite ==7){
                if(matrix[rowWhite][cloeWhite-1].equals("b")){
                    System.out.printf("Game over! White capture on %s.%n"
                            ,Cordinate("w",rowWhite,cloeWhite-1));
                    return;
                }
            }else if (Figth("b",rowWhite, cloeWhite , matrix)){
                if(matrix[rowWhite][cloeWhite-1].equals("b")){
                    System.out.printf("Game over! White capture on %s.%n"
                            ,Cordinate("w",rowWhite,cloeWhite-1));
                    return;
                }else if (matrix[rowWhite][cloeWhite+1].equals("b")){
                    System.out.printf("Game over! White capture on %s.%n"
                            ,Cordinate("w",rowWhite,cloeWhite+1));
                    return;
                }
            }else{
                matrix[rowWhite+1][cloeWhite] = "-";
                matrix[rowWhite][cloeWhite] = "w";
            }



            rowBlack++;
            if(!outOfTheGame(rowBlack, cloeBlack,matrix)){
                System.out.printf("Game over! Black pawn is promoted to a queen at %s.%n"
                        ,Cordinate("b",rowBlack-1,cloeBlack));
                return;
            }else if (cloeBlack ==0) {
                if (matrix[rowBlack][cloeBlack + 1].equals("w")) {
                    System.out.printf("Game over! White capture on %s.", Cordinate("b", rowBlack, cloeBlack+1));
                    return;
                }
            }
            else if (cloeBlack ==7) {
                if (matrix[rowBlack][cloeBlack - 1].equals("w")) {
                    System.out.printf("Game over! White capture on %s.", Cordinate("b", rowBlack, cloeBlack-1));
                    return;
                }
            }else if (Figth("w",rowBlack ,cloeBlack , matrix)) {
                if (matrix[rowBlack][cloeBlack - 1].equals("w")) {
                    System.out.printf("Game over! White capture on %s.", Cordinate("b", rowBlack, cloeBlack-1));
                    return;
                }else if (matrix[rowBlack][cloeBlack + 1].equals("w")){
                    System.out.printf("Game over! White capture on %s.", Cordinate("b", rowBlack, cloeBlack+1));
                    return;
                }
            }else{
                matrix[rowBlack-1][cloeBlack] = "-";
                matrix[rowBlack][cloeBlack] = "b";
            }
        }
    }

    private static boolean Figth(String word , int row, int cloe, String[][] matrix) {
        return matrix[row][cloe-1].equals(word) || matrix[row][cloe+1].equals(word);
    }

    private static String Cordinate(String word,int row, int cloe) {
        StringBuilder print = new StringBuilder();
        switch (cloe){
            case 0 :
                print.append("a");
                break;
            case 1 :
                print.append("b");
                break;
            case 2 :
                print.append("c");
                break;
            case 3 :
                print.append("d");
                break;
            case 4 :
                print.append("e");
                break;
            case 5 :
                print.append("f");
                break;
            case 6 :
                print.append("g");
                break;
            case 7 :
                print.append("h");
                break;
        }
        if(word.equals("w")) {
            print.append(String.format("%d", 8 - row));
        }else if (word.equals("b")){
            print.append(String.format("%d", 8 - row));
        }
        return print.toString();
    }

    private static boolean outOfTheGame(int row, int column , String[][] matrix) {
        return row <= matrix.length-1 && row >= 0 && column <= matrix[0].length-1 && column >= 0;
    }

}
