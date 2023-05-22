package JavaAdvance.Exercises_Multidimensional_Arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String_Matrix_Rotation_06_again {
    public static String [][] matrix180and0;
    public static String [][] matrix90and270;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Pattern pattern =  Pattern.compile("([0-9]+)");
        Matcher matcher = pattern.matcher(command);
        int rotateAngle =0;
        if(matcher.find()) {
            rotateAngle = Integer.parseInt(matcher.group());
        }
        int Angle = rotateAngle %360;
        ArrayDeque<String>que = new ArrayDeque<>();
        int maxLength = Integer.MIN_VALUE;
        String input = scanner.nextLine();
        while(!input.equals("END")){
            que.offer(input);
            if(input.length() > maxLength){
                maxLength = input.length();
            }
            input= scanner.nextLine();
        }
        switch (Angle){
            case 0 :
                matrix180and0 = new String [que.size()][maxLength];
                for (int i = 0; i < matrix180and0.length; i++) {
                    Arrays.fill(matrix180and0[i], " ");
                }
                Rotate0(que, matrix180and0);
                printMatrix(matrix180and0);
                break;
            case 90 :
                matrix90and270 = new String[maxLength][que.size()];
                for (int i = 0; i < matrix90and270.length; i++) {
                    Arrays.fill(matrix90and270[i], " ");
                }
                Rotate90(que);
                printMatrix(matrix90and270);
                break;
            case 180:
                matrix180and0 = new String [que.size()][maxLength];
                for (int i = 0; i < matrix180and0.length; i++) {
                    Arrays.fill(matrix180and0[i], " ");
                }
                Rotate180(que);
                printMatrix(matrix180and0);
                break;
            case 270 :
                matrix90and270 = new String[maxLength][que.size()];
                for (int i = 0; i < matrix90and270.length; i++) {
                    Arrays.fill(matrix90and270[i], " ");
                }
                Rotate270(que);
                printMatrix(matrix90and270);
                break;
        }
    }

    private static void Rotate270(ArrayDeque<String> que) {
        for (int i = 0; i < matrix90and270[0].length; i++) {
            String secondInput = que.pollFirst();
            int counter = 0;
            for (int j = matrix90and270.length-1; j >= 0;j--) {
                if(counter < secondInput.length()) {
                    matrix90and270[j][i] = secondInput.charAt(counter) + "";
                    counter++;
                }else{
                    break;
                }
            }
        }
    }

    private static void Rotate90(ArrayDeque<String> que) {
        for (int i = 0; i < matrix90and270[0].length; i++) {
            String secondInput = que.pollLast();
            int counter = 0;
            while (counter < secondInput.length()) {
                matrix90and270[counter][i] = secondInput.charAt(counter) + "";
                counter++;
            }
        }
    }

    private static void Rotate180(ArrayDeque<String> que) {
        for (int i = matrix180and0.length -1; i >= 0; i--) {
            String secondInput = que.poll();
            int counter =0;
            for (int j = matrix180and0[i].length-1; j >= 0; j--) {
                if(secondInput.length() >counter) {
                    matrix180and0[i][j] = secondInput.charAt(counter) + "";
                    counter++;
                }else{
                    break;
                }
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%s",matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void Rotate0(ArrayDeque<String> que, String[][] matrix) {
        for (int i = 0; i < matrix.length ; i++) {
            String secondInput = que.poll();
            for (int j = 0; j < secondInput.length(); j++) {
                matrix[i][j] = secondInput.charAt(j) + "";
            }
        }
    }
}
