package JavaAdvance.Streams_Files_And_Directories_Lab;

import java.io.*;
import java.util.Scanner;

public class Write_Every_Third_Line_05_again {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = "SoftUni/JavaAdvance/Streams_Files_And_Directories_Lab/input.txt";
        String out = "SoftUni/JavaAdvance/Streams_Files_And_Directories_Lab/YesSirInput.txt";
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        PrintWriter print = new PrintWriter(new FileWriter(out));
        int count = 0;
        String line = buffRead.readLine();
        while(line!=null){
            count++;
            if(count % 3==0){
                print.println(line);
            }
            line = buffRead.readLine();
        }
        buffRead.close();
        print.close();
    }
}
