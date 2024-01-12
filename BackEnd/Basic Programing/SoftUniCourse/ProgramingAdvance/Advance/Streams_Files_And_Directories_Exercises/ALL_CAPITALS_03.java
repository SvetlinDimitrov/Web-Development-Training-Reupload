package JavaAdvance.Streams_Files_And_Directories_Exercises;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class ALL_CAPITALS_03 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader
                ("SoftUni/JavaAdvance/Streams_Files_And_Directories_Exercises/input.txt")));
        PrintWriter print = new PrintWriter
                ("SoftUni/JavaAdvance/Streams_Files_And_Directories_Exercises/output.txt");
        while (scanner.hasNext()){
            print.println(scanner.nextLine().toUpperCase());
        }
        print.close();
        scanner.close();
    }
}
