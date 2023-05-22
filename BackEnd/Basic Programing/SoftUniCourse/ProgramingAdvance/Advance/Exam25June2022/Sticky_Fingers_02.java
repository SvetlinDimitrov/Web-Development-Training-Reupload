package JavaAdvance.Exams.Java_Advanced_Exam25June2022;

import java.util.Scanner;

public class Sticky_Fingers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String [] commands = scanner.nextLine().split(",");


        String [][] matrix = new String [n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }


        int rowStart = 0;
        int cloeStart = 0;
        boolean toBreak = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].equals("D")){
                    rowStart = i;
                    cloeStart = j;
                    toBreak = true;
                    break;
                }
            }
            if(toBreak){
                break;
            }
        }

        int money = 0;
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]){

                case "up":
                    rowStart--;
                    if(!validIndex(rowStart , cloeStart , matrix)){
                        rowStart++;
                        System.out.println("You cannot leave the town, there is police outside!");
                        continue;
                    }else if (police(rowStart , cloeStart , matrix)){
                        System.out.printf("You got caught with %d$, and you are going to jail.%n",money);
                        matrix[rowStart][cloeStart] = "#";
                        matrix[rowStart+1][cloeStart] = "+";
                        printMatrix(matrix);
                        return;
                    }else if (houseToRob(rowStart , cloeStart ,matrix)){
                        money += rowStart*cloeStart;
                        System.out.printf("You successfully stole %d$.%n",rowStart*cloeStart);
                    }
                    matrix[rowStart+1][cloeStart] = "+";
                    matrix[rowStart][cloeStart]="D";
                    break;
                case "down":
                    rowStart++;
                    if(!validIndex(rowStart , cloeStart , matrix)){
                        rowStart--;
                        System.out.println("You cannot leave the town, there is police outside!");
                        continue;
                    }else if (police(rowStart , cloeStart , matrix)){
                        System.out.printf("You got caught with %d$, and you are going to jail.%n",money);
                        matrix[rowStart][cloeStart] = "#";
                        matrix[rowStart-1][cloeStart] = "+";
                        printMatrix(matrix);
                        return;
                    }else if (houseToRob(rowStart , cloeStart ,matrix)){
                        money += rowStart*cloeStart;
                        System.out.printf("You successfully stole %d$.%n",rowStart*cloeStart);
                    }
                    matrix[rowStart-1][cloeStart] = "+";
                    matrix[rowStart][cloeStart]="D";
                    break;
                case "right":
                    cloeStart++;
                    if(!validIndex(rowStart , cloeStart , matrix)){
                        cloeStart--;
                        System.out.println("You cannot leave the town, there is police outside!");
                        continue;
                    }else if (police(rowStart , cloeStart , matrix)){
                        System.out.printf("You got caught with %d$, and you are going to jail.%n",money);
                        matrix[rowStart][cloeStart] = "#";
                        matrix[rowStart][cloeStart-1] = "+";
                        printMatrix(matrix);
                        return;
                    }else if (houseToRob(rowStart , cloeStart ,matrix)){
                        money += rowStart*cloeStart;
                        System.out.printf("You successfully stole %d$.%n",rowStart*cloeStart);
                    }
                    matrix[rowStart][cloeStart-1] = "+";
                    matrix[rowStart][cloeStart]="D";
                    break;
                case "left":
                    cloeStart--;
                    if(!validIndex(rowStart , cloeStart , matrix)){
                        cloeStart++;
                        System.out.println("You cannot leave the town, there is police outside!");
                        continue;
                    }else if (police(rowStart , cloeStart , matrix)){
                        System.out.printf("You got caught with %d$, and you are going to jail.%n",money);
                        matrix[rowStart][cloeStart] = "#";
                        matrix[rowStart][cloeStart+1] = "+";
                        printMatrix(matrix);
                        return;
                    }else if (houseToRob(rowStart , cloeStart ,matrix)){
                        money += rowStart*cloeStart;
                        System.out.printf("You successfully stole %d$.%n",rowStart*cloeStart);
                    }
                    matrix[rowStart][cloeStart+1] = "+";
                    matrix[rowStart][cloeStart]="D";
                    break;
            }
        }
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n",money);
        printMatrix(matrix);

    }
    public static boolean validIndex (int  row , int cloe , String [][]matrix){
        return row <=matrix.length-1 && row>=0 && cloe <= matrix[0].length-1 && cloe >=0;
    }
    public static boolean police(int row , int cloe , String [][] matrix){
        return matrix[row][cloe].equals("P");
    }

    public static boolean houseToRob(int row , int cloe , String [][] matrix){
        return matrix[row][cloe].equals("$");
    }

    public static void printMatrix(String[][]matrix){
        StringBuilder print = new StringBuilder();
        for (String[] strings : matrix) {
            print.append(String.format("%s%n",String.join(" ",strings)));
        }
        System.out.println(print.toString());
    }
}
