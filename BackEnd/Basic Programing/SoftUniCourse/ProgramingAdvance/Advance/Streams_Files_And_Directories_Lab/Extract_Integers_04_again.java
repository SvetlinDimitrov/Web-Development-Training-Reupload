package JavaAdvance.Streams_Files_And_Directories_Lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Extract_Integers_04_again {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\4orapa\\IdeaProjects\\First step in coding\\SoftUni\\JavaAdvance\\Streams_Files_And_Directories_Lab\\input.txt";
        Scanner scanner = new Scanner(new FileInputStream(path));
        while(scanner.hasNext()){
            if(scanner.hasNextInt()){
                System.out.println(scanner.nextInt());
            }
            scanner.next();
        }
    }
}
