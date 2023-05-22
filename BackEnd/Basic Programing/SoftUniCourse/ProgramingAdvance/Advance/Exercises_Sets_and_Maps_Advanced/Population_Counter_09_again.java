package JavaAdvance.Exercises_Sets_and_Maps_Advanced;

import java.util.*;

public class Population_Counter_09_again {
    public static int sum;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , Map<String, Integer>> map = new HashMap<>();
        String input = scanner.nextLine();
        while(!input.equals("report")){
            String country = input.split("\\|")[1];
            String city = input.split("\\|")[0];
            int population = Integer.parseInt(input.split("\\|")[2]);

            map.putIfAbsent(country , new HashMap<>());
            map.get(country).putIfAbsent(city , 0);
            map.get(country).put(city , map.get(country).get(city) + population);

            input= scanner.nextLine();
        }
        StringBuilder print = new StringBuilder();
        map.forEach((key , value)-> {
            sum =0;
            value.forEach((k,v) -> {
                print.append(String.format("=>%s: %d%n",k,v));
                sum+=v;
            });
            System.out.printf("%s (total population: %d)%n",key,sum);
            System.out.printf("%s",print);
            print.delete(0 , print.length());

        });
    }
}
