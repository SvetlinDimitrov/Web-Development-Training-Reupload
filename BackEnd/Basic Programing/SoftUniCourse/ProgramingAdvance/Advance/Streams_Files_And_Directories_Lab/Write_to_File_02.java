package JavaAdvance.Streams_Files_And_Directories_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Write_to_File_02 {
    public static void main(String[] args) throws  IOException{
        String path = "C:\\Users\\4orapa\\IdeaProjects\\First step in coding\\SoftUni\\JavaAdvance\\Streams_Files_And_Directories_Lab\\input.txt";
        FileInputStream input = new FileInputStream(path);
        String pathOut = "C:\\Users\\4orapa\\IdeaProjects\\First step in coding\\SoftUni\\JavaAdvance\\Streams_Files_And_Directories_Lab\\02.WriteToFileOutput.txt";
        FileOutputStream outPrint = new FileOutputStream(pathOut);
        Set<Character> set = new HashSet<>();
        set.add(',');
        set.add('.');
        set.add('!');
        set.add('?');
        int oneByte = input.read();
        while (oneByte != -1) {
            if(!set.contains((char)oneByte))
            outPrint.write(oneByte);
            oneByte = input.read();
        }
    }
}
