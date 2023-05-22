package JavaAdvance.Streams_Files_And_Directories_Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Sum_Lines_01 {
    public static char[] letters;
    public static int sum;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new FileReader
                        ("SoftUni/JavaAdvance/Streams_Files_And_Directories_Exercises/input.txt"));
        String input = in.readLine();
        while(input != null){
            letters = input.toCharArray();
            sum =0;
            for (char letter : letters) {
                sum+=letter;
            }
            System.out.println(sum);
            input = in.readLine();
        }

    }
}
