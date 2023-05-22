package JavaAdvance.Exercises_Sets_and_Maps_Advanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Sets_of_Elements_02_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double , Integer> map = new LinkedHashMap<>();
        int [] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < Arrays.stream(nums).sum(); i++) {
            double num = Double.parseDouble(scanner.nextLine());
            map.putIfAbsent(num , 0);
            map.put(num , map.get(num)+1);
        }
        map.forEach((key , value)->{
            if(value >=2){
                System.out.printf("%.0f ",key);
            }
        });
    }
}
