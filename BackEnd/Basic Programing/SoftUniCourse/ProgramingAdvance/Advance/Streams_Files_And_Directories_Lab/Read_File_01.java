package JavaAdvance.Streams_Files_And_Directories_Lab;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Read_File_01 {
    public static void main(String[] args){
        String input = "C:\\Users\\4orapa\\IdeaProjects\\First step in coding\\SoftUni\\JavaAdvance\\Streams_Files_And_Directories_Lab\\input.txt";
        try (FileInputStream file = new FileInputStream(input)){
            int oneByte = file.read();
            while(oneByte>=0){
                String print = Integer.toBinaryString(oneByte);
                System.out.printf("%s ",print);
                oneByte = file.read();
        }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
