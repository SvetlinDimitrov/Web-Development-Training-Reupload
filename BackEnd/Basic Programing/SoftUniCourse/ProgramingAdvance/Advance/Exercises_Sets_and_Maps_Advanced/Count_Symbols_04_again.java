package JavaAdvance.Exercises_Sets_and_Maps_Advanced;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Count_Symbols_04_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character , Integer> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split(""))
                .forEach(e-> {
                    map.putIfAbsent(e.charAt(0) , 0);
                    map.put(e.charAt(0) , map.get(e.charAt(0))+1);
                });
        map.forEach((k,v)-> System.out.printf("%c: %d time/s%n",k,v));
    }
}
