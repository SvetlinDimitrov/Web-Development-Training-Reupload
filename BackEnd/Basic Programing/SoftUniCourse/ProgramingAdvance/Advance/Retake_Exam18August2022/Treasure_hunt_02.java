package JavaAdvance.Exams.Java_Advanced_Retake_Exam18August2022;

import java.util.*;
import java.util.stream.Collectors;

public class Treasure_hunt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> commands = new ArrayDeque<>();
        int [] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String [][] matrix = new String[input[0]][input[1]];
        for (int i = 0; i <matrix.length ; i++) {
                matrix[i] = scanner.nextLine().split(" ");
            }


        int rowStart = 0;
        int cloeStart = 0;
        boolean Find = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].equals("Y")){
                    Find = true;
                    rowStart = i;
                    cloeStart =j;
                    break;
                }
            }
            if(Find){
                break;
            }
        }

        String command = scanner.nextLine();
        while(!command.equals("Finish")){
            commands.push(command);
            switch (command){
                case "up":
                    rowStart--;
                    if(!validIndex(rowStart , cloeStart ,matrix)){
                        rowStart++;
                        commands.pop();
                    }
                    if(matrix[rowStart][cloeStart].equals("T")){
                        rowStart++;
                        commands.pop();
                    }
                    break;

                case "down":
                    rowStart++;
                    if(!validIndex(rowStart , cloeStart ,matrix)){
                        rowStart--;
                        commands.pop();
                    }
                    if(matrix[rowStart][cloeStart].equals("T")){
                        rowStart--;
                        commands.pop();
                    }
                    break;
                case "right":
                    cloeStart++;
                    if(!validIndex(rowStart , cloeStart ,matrix)){
                        cloeStart--;
                        commands.pop();
                    }
                    if(matrix[rowStart][cloeStart].equals("T")){
                        cloeStart--;
                        commands.pop();
                    }

                    break;
                case "left":
                    cloeStart--;
                    if(!validIndex(rowStart , cloeStart ,matrix)){
                        cloeStart++;
                        commands.pop();
                    }
                    if(matrix[rowStart][cloeStart].equals("T")){
                        cloeStart++;
                        commands.pop();
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        List <String> listToPrint = commands.stream().collect(Collectors.toList());
        Collections.reverse(listToPrint);
        if(matrix[rowStart][cloeStart].equals("X")){
            System.out.println("I've found the treasure!");
            System.out.printf("The right path is %s",String.join(", " ,listToPrint));
        }else{
            System.out.println("The map is fake!");
        }

    }
    public static boolean validIndex(int row , int cloe , String[][]matrix){
        return row <=matrix.length-1 && row >= 0
                && cloe <= matrix[0].length-1 && cloe>=0;
    }

}
