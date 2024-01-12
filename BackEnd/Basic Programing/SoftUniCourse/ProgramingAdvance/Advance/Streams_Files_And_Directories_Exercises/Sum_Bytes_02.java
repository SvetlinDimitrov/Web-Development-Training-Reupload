package JavaAdvance.Streams_Files_And_Directories_Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Sum_Bytes_02 {
    public static int sum;
    public static char [] letters;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader
                ("SoftUni/JavaAdvance/Streams_Files_And_Directories_Exercises/input.txt")));

        while(scanner.hasNext()){
            letters = scanner.nextLine().toCharArray();
            for (char letter : letters) {
                sum+=letter;
            }
        }
        System.out.println(sum);
    }
}
