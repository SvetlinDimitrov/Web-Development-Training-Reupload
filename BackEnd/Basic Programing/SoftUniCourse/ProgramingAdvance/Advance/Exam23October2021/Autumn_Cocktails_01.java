package JavaAdvance.Exams.Java_Advanced_Exam23October2021;

import java.util.*;

public class Autumn_Cocktails_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> buckets = new ArrayDeque<>();
        ArrayDeque<Integer> freshman = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .forEach(buckets::offerLast);
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .forEach(freshman::push);

        Map<String , Map<Integer , Integer>> cocktails = new LinkedHashMap<>();
        cocktails.put("Pear Sour" , new HashMap<>());
        cocktails.get("Pear Sour").put(150 , 0);
        cocktails.put("The Harvest" , new HashMap<>());
        cocktails.get("The Harvest").put(250 , 0);
        cocktails.put("Apple Hinny" , new HashMap<>());
        cocktails.get("Apple Hinny").put(300 , 0);
        cocktails.put("High Fashion" , new HashMap<>());
        cocktails.get("High Fashion").put(400 , 0);

        int sum = 0;
        while(!buckets.isEmpty() && !freshman.isEmpty()){
            int first = buckets.pollFirst();
            int second = freshman.pop();
            sum = first * second;

            if(sum == 150){
                cocktails.get("Pear Sour").put(150 , cocktails.get("Pear Sour").get(150) + 1);
            }else if(sum == 250){
                cocktails.get("The Harvest").put(250 , cocktails.get("The Harvest").get(250) + 1);
            }else if (sum == 300){
                cocktails.get("Apple Hinny").put(300 , cocktails.get("Apple Hinny").get(300) + 1);
            }else if (sum == 400){
                cocktails.get("High Fashion").put(400 , cocktails.get("High Fashion").get(400) + 1);
            }else {
                buckets.offerLast(first+5);
            }
        }
        boolean isTrue = true;
        for (Map.Entry<String, Map<Integer, Integer>> map : cocktails.entrySet()) {
            for (Map.Entry<Integer, Integer> map2 : map.getValue().entrySet()) {
                if (!(map2.getValue() >= 1)) {
                    isTrue = false;
                    break;
                }
            }
        }
        if (isTrue){
            System.out.println("It's party time! The cocktails are ready!");
        }else{
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if(!buckets.isEmpty()){
            System.out.printf("Ingredients left: %d%n",
                    buckets.stream().mapToInt(e->e).sum());
        }

        if(cocktails.get("Apple Hinny").get(300) >= 1){
            System.out.printf(" # Apple Hinny --> %d%n",cocktails.get("Apple Hinny").get(300) );
        }
        if(cocktails.get("High Fashion").get(400) >= 1){
            System.out.printf(" # High Fashion --> %d%n",cocktails.get("High Fashion").get(400) );
        }
        if(cocktails.get("Pear Sour").get(150) >= 1){
            System.out.printf(" # Pear Sour --> %d%n",cocktails.get("Pear Sour").get(150) );
        }
        if(cocktails.get("The Harvest").get(250) >= 1){
            System.out.printf(" # The Harvest --> %d%n",cocktails.get("The Harvest").get(250) );
        }
    }
}
