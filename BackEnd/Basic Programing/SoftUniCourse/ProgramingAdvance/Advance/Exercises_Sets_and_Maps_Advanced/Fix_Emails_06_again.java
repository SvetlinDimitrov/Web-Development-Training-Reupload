package JavaAdvance.Exercises_Sets_and_Maps_Advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Fix_Emails_06_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , String> map = new LinkedHashMap<>();
        String name = scanner.nextLine();
        while(!name.equals("stop")){
            String abv = scanner.nextLine();
            map.putIfAbsent(name , abv);
            name= scanner.nextLine();
        }

        map.forEach((k,v) -> {
            if(!v.contains(".us") && !v.contains(".uk") && !v.contains(".com")){
                System.out.printf("%s -> %s%n",k,v);
            }
        });
    }
}
