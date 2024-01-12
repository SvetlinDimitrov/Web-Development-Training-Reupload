package JavaAdvance.Streams_Files_And_Directories_Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Word_Count_06 {
    public static void main(String[] args) throws IOException {
        Map<String , Integer> map =new LinkedHashMap<>();
        Scanner scanner = new Scanner(new BufferedReader(new FileReader
                ("SoftUni/JavaAdvance/Streams_Files_And_Directories_Exercises/words.txt")));
        while (scanner.hasNext()){
            map.putIfAbsent(scanner.next(), 0);
        }
        scanner = new Scanner(new BufferedReader(new FileReader
                ("SoftUni/JavaAdvance/Streams_Files_And_Directories_Exercises/text.txt")));
        while(scanner.hasNext()){
            String input = scanner.next();
            if(map.containsKey(input)){
                map.put(input , map.get(input)+1);
            }
        }
        scanner.close();
        PrintWriter print = new PrintWriter
                ("SoftUni/JavaAdvance/Streams_Files_And_Directories_Exercises/output.txt");
        for (String s : map.keySet()) {
            print.println(String.format("%s - %d",s,map.get(s)));
        }
        print.close();
    }
}
