package JavaAdvance.Streams_Files_And_Directories_Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Count_Character_Types_04 {
    public static char[] letters;
    public static int vowels;
    public static int consonants;
    public static int punctuation;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader
                ("SoftUni/JavaAdvance/Streams_Files_And_Directories_Exercises/input.txt")));
        PrintWriter print = new PrintWriter
                ("SoftUni/JavaAdvance/Streams_Files_And_Directories_Exercises/output.txt");
        while(scanner.hasNext()){
            letters = scanner.nextLine().toCharArray();
            for (char letter : letters) {
                switch (letter){
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        vowels++;
                        break;
                    case '!':
                    case ',':
                    case'.':
                    case '?':
                        punctuation++;
                        break;
                    case ' ':
                        break;
                    default:
                        consonants++;
                }
            }
        }
        print.println(String.format("Vowels: %d",vowels));
        print.println(String.format("Consonants: %d",consonants));
        print.println(String.format("Punctuation: %d",punctuation));
        scanner.close();
        print.close();
    }
}
