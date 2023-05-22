package JavaAdvance.Streams_Files_And_Directories_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Extract_Integers_04 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\4orapa\\IdeaProjects\\First step in coding\\SoftUni\\JavaAdvance\\Streams_Files_And_Directories_Lab\\input.txt";
        String pathOut = "C:\\Users\\4orapa\\IdeaProjects\\First step in coding\\SoftUni\\JavaAdvance\\Streams_Files_And_Directories_Lab\\04.ExtractIntegersOutput.txt";
        Scanner scanner = new Scanner(path);
        FileOutputStream out = new FileOutputStream(pathOut);
        PrintWriter write = new PrintWriter(out);
        while(scanner.hasNext()){
            if(scanner.hasNextInt()){
                write.println(scanner.next());
            }
            scanner.next();
        }
        write.close();
    }
}
