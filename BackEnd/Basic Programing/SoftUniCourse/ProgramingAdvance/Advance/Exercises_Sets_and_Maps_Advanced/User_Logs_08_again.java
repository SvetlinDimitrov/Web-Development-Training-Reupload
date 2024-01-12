package JavaAdvance.Exercises_Sets_and_Maps_Advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class User_Logs_08_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , Map<String , Integer>> map = new TreeMap<>();
        String [] input = scanner.nextLine().split(" ");
        while(!input[0].equals("end")){
            String ip = input[0].split("=")[1];
            String name = input[2].split("=")[1];
            map.putIfAbsent(name , new LinkedHashMap<>());
            map.get(name) .putIfAbsent(ip , 0);
            map.get(name).put(ip , map.get(name).get(ip)+1);
            input = scanner.nextLine().split(" ");
        }
        StringBuilder build = new StringBuilder();
        map.forEach((key , value)-> {
            build.append(String.format("%s: %n",key));
            value.forEach((secondKey , secondValue) ->{
                build.append(String.format("%s => %d, ",secondKey,secondValue));
            });
            int indexLastComma = build.lastIndexOf(",");
            build.replace(indexLastComma, indexLastComma +1, ".");
            System.out.println(build);
            build.delete(0 , build.length());
        });
    }
}
