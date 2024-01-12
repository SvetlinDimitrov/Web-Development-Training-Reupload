package JavaAdvance.Exams.Java_Advanced_Exam23October2021;

import java.util.Scanner;

public class Mouse_and_Cheese_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char [][] matrix = new char[n][n];

        int rowMouse = -1;
        int cloeMouse = -1;


        for (int i = 0; i < matrix.length; i++) {
                matrix[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 'M'){
                    rowMouse =i;
                    cloeMouse = j;
                }
            }
        }

        int cheese =0;
        String command = scanner.nextLine();
        while(!command.equals("end")){
            matrix[rowMouse][cloeMouse] = '-';
            switch (command){
                case "up":
                    rowMouse--;
                    break;
                case "down":
                    rowMouse++;
                    break;
                case "left":
                    cloeMouse--;
                    break;
                case "right":
                    cloeMouse++;
                    break;
            }
            if(!indexValid(rowMouse , cloeMouse , matrix)){
                System.out.println("Where is the mouse?");
                break;
            }else if(matrix[rowMouse][cloeMouse] == 'c'){
                cheese++;
            }else if (matrix[rowMouse][cloeMouse] =='B'){
                continue;
            }
            matrix[rowMouse][cloeMouse] ='M';

            command = scanner.nextLine();
        }
        if(cheese >= 5){
            System.out.printf("Great job, the mouse is fed %d cheeses!%n",cheese);
        }else{
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",5-cheese);
        }
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.printf("%c",aChar);
            }
            System.out.println();
        }

    }

    private static boolean indexValid(int rowMouse, int cloeMouse, char[][] matrix) {
        return rowMouse <= matrix.length-1 && rowMouse >= 0
                && cloeMouse <= matrix[0].length-1 && cloeMouse >= 0;
    }
}
