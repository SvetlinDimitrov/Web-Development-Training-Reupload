package JavaAdvance.Streams_Files_And_Directories_Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Line_Numbers_05 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader
                ("SoftUni/JavaAdvance/Streams_Files_And_Directories_Exercises/inputLineNumbers.txt")));
        PrintWriter print = new PrintWriter
                ("SoftUni/JavaAdvance/Streams_Files_And_Directories_Exercises/output.txt");
        int countLine =1;
        while(scanner.hasNext()){
            print.println(String.format("%d. %s",countLine,scanner.nextLine()));
            countLine++;
        }
        print.close();
        scanner.close();
    }
}
