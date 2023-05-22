package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.util.*;

public class Cities_by_Continent_and_Country_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Map<String , Map<String , ArrayList<String>>> map = new LinkedHashMap<>();
        for (int i = 0; i < times; i++) {
            String input = scanner.nextLine();
            String continent = input.split(" ")[0];
            String country = input.split(" ")[1];
            String city = input.split(" ")[2];

            if(!map.containsKey(continent)){
                map.put(continent , new LinkedHashMap<>());
                map.get(continent).put(country , new ArrayList<>());
                map.get(continent).get(country).add(city);
            }else{
                if(!map.get(continent).containsKey(country)){
                    map.get(continent).put(country , new ArrayList<>());
                    map.get(continent).get(country).add(city);
                }else{
                    map.get(continent).get(country).add(city);
                }
            }

        }
        for (Map.Entry<String , Map<String , ArrayList<String>>> mainEntry : map.entrySet()){
            System.out.printf("%s:%n",mainEntry.getKey());
            for (Map.Entry<String , ArrayList<String>> entry : mainEntry.getValue().entrySet()){
                System.out.printf("  %s -> ",entry.getKey());
                System.out.println(String.join(", " , entry.getValue()));
            }
        }
    }
}
