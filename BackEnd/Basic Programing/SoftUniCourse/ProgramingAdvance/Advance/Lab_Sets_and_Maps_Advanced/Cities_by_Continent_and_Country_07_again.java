package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.util.*;

public class Cities_by_Continent_and_Country_07_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int times = Integer.parseInt(scanner.nextLine());
        Map<String , Map<String , ArrayList<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < times; i++) {
            String input = scanner.nextLine();
            String continent = input.split(" ")[0];
            String country = input.split(" ")[1];
            String city = input.split(" ")[2];

            map.putIfAbsent(continent , new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country , new ArrayList<>());
            map.get(continent).get(country).add(city);
        }
        for(Map.Entry<String , Map<String , ArrayList<String>>> print : map.entrySet()){
            System.out.printf("%s:%n",print.getKey());
            for(Map.Entry<String , ArrayList<String>> print2 : print.getValue().entrySet()){
                System.out.printf("%s -> ",print2.getKey());
                System.out.println(String.join(", ",print2.getValue()));
            }
        }
    }
}
