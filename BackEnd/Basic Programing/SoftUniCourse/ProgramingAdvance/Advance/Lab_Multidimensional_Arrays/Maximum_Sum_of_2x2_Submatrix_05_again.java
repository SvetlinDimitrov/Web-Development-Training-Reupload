package JavaAdvance.Lab_Multidimensional_Arrays;

import java.util.*;

public class Maximum_Sum_of_2x2_Submatrix_05_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] elements1 = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = elements1[0];
        int cloe = elements1[1];

            //reading matrix from the input
        int [][] matrix = new int[row][cloe];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                    .toArray();
        }

            // creating List to save the biggest nums on every row in the matrix

        String save = "";
        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int sumEl1 = Integer.MIN_VALUE;
            for (int j = 0; j < matrix[i].length; j+=2) {
                int sumEl = matrix[i][j] + matrix[i][j+1];
                if(sumEl > sumEl1){
                    sumEl1 = sumEl;
                    save = String.format("%d %d",matrix[i][j] , matrix[i][j+1]);
                }
            }
            words.add(save);
        }

            //creating array to find the biggest nums from each array row

        int [] allNum = new int [words.size()];
        for (int i = 0; i < words.size(); i++) {
            allNum[i] = Arrays.stream(words.get(i).split(" "))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
            // finding the largestNum

        int biggestNum =Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < allNum.length; i++) {
            if(biggestNum < allNum[i] ){
                biggestNum = allNum[i];
                index = i;
            }
        }
            //finding the secondLargestNum

        int secondBigNum = Integer.MIN_VALUE;
        int secondIndex = 0;

        for (int i = 0; i < allNum.length; i++) {
            if(secondBigNum < allNum[i] && index !=i){
                secondBigNum = allNum[i];
                secondIndex = i;
            }
        }

        //print

        if (index > secondIndex){
            System.out.println(words.get(secondIndex));
            System.out.println(words.get(index));
        }else{
            System.out.println(words.get(index));
            System.out.println(words.get(secondIndex));
        }
        System.out.println(secondBigNum + biggestNum);
    }
}
