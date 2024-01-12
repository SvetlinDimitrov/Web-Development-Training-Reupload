package ProgramingFundamentalsJava.Lab_Associative_Arrays_Lambda_and_Stream_API;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter_04_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] words = Arrays.stream(scanner.nextLine().split(" ")).filter(w->w.length()%2 == 0).toArray(String [] ::new);
        for(String word : words){
            System.out.println(word);
        }
    }
}
