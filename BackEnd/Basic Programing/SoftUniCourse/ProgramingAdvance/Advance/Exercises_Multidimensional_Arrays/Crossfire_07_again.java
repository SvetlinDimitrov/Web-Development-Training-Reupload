package JavaAdvance.Exercises_Multidimensional_Arrays;

import javax.xml.transform.SourceLocator;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Crossfire_07_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String [][] matrix = new String [input[0]][input[1]];
        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = count + "";
                count++;
            }
        }

        String inputSecond = scanner.nextLine();
        while(!inputSecond.equals("Nuke it from orbit")){
            int row = Integer.parseInt(inputSecond.split(" ")[0]);
            int cloe = Integer.parseInt(inputSecond.split(" ")[1]);
            int radius = Integer.parseInt(inputSecond.split(" ")[2]);
            if (Valid(row,cloe,radius,matrix)){
                //right
                RightExplotion(matrix ,row , cloe , radius);
                //left
                LeftExplotion(matrix ,row , cloe , radius);
                //up
                UpExplotion(matrix ,row , cloe , radius);
                //down
                DownExplotion(matrix ,row , cloe , radius);
                matrix[row][cloe] = "";
                FixMatrix(matrix);

            }
            inputSecond = scanner.nextLine();
        }
        PrintMatrix(matrix);
    }

    private static void FixMatrix(String[][] matrix) {
        ArrayDeque<String> que = new ArrayDeque<>();
        int cloe;
        int row;
        String save;
        for (int i = 0; i < matrix.length; i++) {
            que.clear();
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].equals("")){
                    que.offer(String.format("%d %d",i,j));
                }else if (!matrix[i][j].equals("") && !que.isEmpty()){
                    save = que.poll();
                    row = Integer.parseInt(save.split(" ")[0]);
                    cloe = Integer.parseInt(save.split(" ")[1]);
                    matrix[row][cloe] = matrix[i][j];
                    matrix[i][j]= "";
                    que.offer(String.format("%d %d",i,j));
                }
            }
        }
    }

    private static void DownExplotion(String[][] matrix, int row, int cloe, int radius) {
        int cloeSave = cloe+1;
        int count =0;
        while(Valid(row , cloeSave ,radius ,matrix)){
            if(count == radius) {
                return;
            }else{
                matrix[row][cloeSave] = "";
                count++;
                cloeSave++;
            }
        }
    }

    private static void UpExplotion(String[][] matrix, int row, int cloe, int radius) {
        int cloeSave = cloe-1;
        int count =0;
        while(Valid(row , cloeSave ,radius ,matrix)){
            if(count == radius) {
                return;
            }else{
                matrix[row][cloeSave] = "";
                count++;
                cloeSave--;
            }
        }
    }

    private static void PrintMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(String.join(" " , matrix[i]));
        }
    }

    private static void LeftExplotion(String[][] matrix, int row, int cloe, int radius) {
        int rowSave = row-1;
        int count =0;
        while(Valid(rowSave , cloe ,radius ,matrix)){
            if(count == radius) {
                return;
            }else{
                matrix[rowSave][cloe] = "";
                count++;
                rowSave--;
            }
        }
    }

    private static void RightExplotion(String[][] matrix, int row, int cloe, int radius) {
        int rowSave = row+1;
        int count =0;
        while(Valid(rowSave , cloe ,radius ,matrix)){
            if(count == radius) {
                return;
            }else{
                matrix[rowSave][cloe] = "";
                count++;
                rowSave++;
            }
        }
    }

    private static boolean Valid(int row, int cloe, int radius, String[][] matrix) {
        return matrix.length-1 >= row && row>= 0 && matrix[row].length-1 >= cloe && cloe>=0;
    }
}
