package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.text.DecimalFormat;
import java.util.*;

public class Academy_Graduation_08_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , ArrayList<Double>> map = new LinkedHashMap<>();
        int times = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < times; i++) {
            String name = scanner.nextLine();
            map.putIfAbsent(name , new ArrayList<>());
            Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .forEach(e-> map.get(name).add(e));
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        for(Map.Entry<String , ArrayList<Double>> print : map.entrySet()){
            System.out.printf("%s is graduated with %s%n",print.getKey() , decimalFormat.format(print.getValue().stream().mapToDouble(e->e).average()));
        }
    }
}
