package JavaAdvance.Exercises_Sets_and_Maps_Advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Sets_of_Elements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int firstNum = Integer.parseInt(input.split(" ")[0]);
        int secondNum = Integer.parseInt(input.split(" ")[1]);
        int sum = firstNum + secondNum;
        Map<String , Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < sum; i++) {
            String el = scanner.nextLine();
            map.putIfAbsent(el, 0);
            map.put(el , map.get(el) + 1);
        }
        for(var entry : map.entrySet()){
            if (entry.getValue() >= 2){
                System.out.printf("%s ",entry.getKey());
            }
        }
    }
}
