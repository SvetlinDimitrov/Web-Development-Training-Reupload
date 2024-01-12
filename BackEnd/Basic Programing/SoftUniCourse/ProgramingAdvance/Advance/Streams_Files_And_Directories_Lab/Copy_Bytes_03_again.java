package JavaAdvance.Streams_Files_And_Directories_Lab;

import java.io.FileInputStream;
import java.io.IOException;


public class Copy_Bytes_03_again {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\4orapa\\IdeaProjects\\First step in coding\\SoftUni\\JavaAdvance\\Streams_Files_And_Directories_Lab\\input.txt";
        FileInputStream stream = new FileInputStream(path);

        int num = stream.read();
        while(num>=0){
            if( num == 32 || num == 10){
                System.out.printf("%c" , num);
            }else{
                System.out.printf("%d" , num);
            }
            num = stream.read();
        }
    }
}
