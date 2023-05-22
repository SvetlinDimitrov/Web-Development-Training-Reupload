package JavaAdvance.Lab_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Find_the_Real_Queen_07_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [][] matrix = new String [8][8];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].equals("q")){
                    
                    // checking the row
                    int countQ = 0;
                    for (int k = 0; k < matrix[i].length; k++) {
                        if(matrix[i][k].equals("q")){
                            countQ++;
                        }
                    }
                    Arrays.fill(matrix[i], "no");
                    if(countQ>=2) {
                        break;
                    }else{
                        matrix[i][j] = "q";
                    }
                    
                    
                    // checking the cloe
                    countQ=0;
                    for (int k = 0; k < matrix[i].length; k++) {
                        if(matrix[k][j].equals("q")){
                            countQ++;
                        }
                    }
                    for (int k = 0; k < matrix[i].length; k++) {
                        matrix[k][j] = "no";
                    }
                    if(countQ <= 2){
                        matrix[i][j] = "q";
                    }else{
                        break;
                    }


                    // checking left-up nad right-down
                    countQ=0;
                    int row = i;
                    int cloe = j;
                    while(Valid(row,cloe,matrix)){
                        if(matrix[row][cloe].equals("q")){
                            countQ++;
                        }
                        matrix[row][cloe] = "no";
                        row--;
                        cloe--;
                    }
                    row = i+1;
                    cloe =j+1;
                    while(Valid(row,cloe,matrix)){
                        if(matrix[row][cloe].equals("q")){
                            countQ++;
                        }
                        matrix[row][cloe] = "no";
                        row++;
                        cloe++;
                    }
                    if(countQ >=2){
                        break;
                    }else{
                        matrix[i][j]="q";
                    }

                    // checking right-up nad left-down
                    countQ=0;
                    row = i;
                    cloe = j;
                    while(Valid(row,cloe,matrix)){
                        if(matrix[row][cloe].equals("q")){
                            countQ++;
                        }
                        matrix[row][cloe] = "no";
                        row--;
                        cloe++;
                    }
                    row = i+1;
                    cloe =j-1;
                    while(Valid(row,cloe,matrix)){
                        if(matrix[row][cloe].equals("q")){
                            countQ++;
                        }
                        matrix[row][cloe] = "no";
                        row++;
                        cloe--;
                    }
                    if(countQ >=2){
                        break;
                    }else{
                        matrix[i][j]="q";
                    }
                    System.out.printf("%d %d",i,j);
                    return ;
                }
            }
        }
    }

    private static boolean Valid(int row, int cloe, String[][] matrix) {
        return matrix.length-1 >= row && row >=0 && matrix[row].length-1 >=cloe && cloe >=0;
    }
}
