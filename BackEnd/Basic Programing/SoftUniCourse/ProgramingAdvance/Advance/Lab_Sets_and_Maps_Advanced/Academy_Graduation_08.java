package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.util.*;

public class Academy_Graduation_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Map<String , ArrayList<Double>> map = new LinkedHashMap<>();

        for (int i = 0; i < times; i++) {
            String name = scanner.nextLine();
            double [] grades = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            if(!map.containsKey(name)){
                map.put(name , new ArrayList<>());
                for (double grade : grades) {
                    map.get(name).add(grade);
                }
            }else {
                for (double grade : grades) {
                    map.get(name).add(grade);
                }
            }
        }
        for (Map.Entry<String , ArrayList<Double>> entry : map.entrySet()){
            System.out.printf("%s is graduated with ",entry.getKey());
            double gradeAverage = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                gradeAverage += entry.getValue().get(i);
            }
            System.out.printf("%f%n",gradeAverage/entry.getValue().size());
        }
    }
}
