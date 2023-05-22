package JavaAdvance.Streams_Files_And_Directories_Lab;

import java.io.*;
import java.util.Scanner;

public class Write_Every_Third_Line_05 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = "C:\\Users\\4orapa\\IdeaProjects\\First step in coding\\SoftUni\\JavaAdvance\\Streams_Files_And_Directories_Lab\\input.txt";
        String pathOut = "C:\\Users\\4orapa\\IdeaProjects\\First step in coding\\SoftUni\\JavaAdvance\\Streams_Files_And_Directories_Lab\\05.WriteEveryThirdLineOutput.txt";
        BufferedReader in = new BufferedReader(new FileReader(path));
        PrintWriter write = new PrintWriter(new FileWriter(pathOut));
        int count = 1 ;
        String line = in.readLine();
        while(line!=null){
            if(count%3==0) {
                write.println(line);
            }
                count++;
                line = in.readLine();
        }
    }
}
