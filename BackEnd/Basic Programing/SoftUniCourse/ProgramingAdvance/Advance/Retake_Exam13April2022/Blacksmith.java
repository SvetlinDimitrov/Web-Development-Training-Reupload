package JavaAdvance.Exams.Java_Advanced_Retake_Exam13April2022;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static List<String> list;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer>steel = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer>carbon = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int gladius=0;
        int shamshir =0;
        int katana =0;
        int sebre =0;

        while(!steel.isEmpty() && !carbon.isEmpty()){
            int steelNum = steel.pollFirst();
            int carbonNum = carbon.pollLast();
            int sum = steelNum+carbonNum;

            if(sum ==70 || sum==80 || sum==90 || sum==110){
                switch (sum){
                    case 70:
                        gladius++;
                        break;
                    case 80:
                        shamshir++;
                        break;
                    case 90:
                        katana++;
                        break;
                    case 110:
                        sebre++;
                        break;
                }
            }else{
                carbon.offerLast(carbonNum+5);
            }
        }
        if(gladius+shamshir+katana+sebre >=1){
            System.out.printf("You have forged %d swords.%n",gladius+shamshir+katana+sebre);
        }else{
            System.out.println("You did not have enough resources to forge a sword.");
        }
         if(steel.isEmpty()){
             System.out.println("Steel left: none");
         }else{
             list = steel.stream().map(String::valueOf).collect(Collectors.toList());
             Collections.reverse(list);
             System.out.printf("Steel left: %s%n",String.join(", ",list));
         }

         if(carbon.isEmpty()){
             System.out.println("Carbon left: none");
         }else{
             list = carbon.stream().map(String::valueOf).collect(Collectors.toList());
             Collections.reverse(list);
             System.out.printf("Carbon left: %s%n",String.join(", ",list));
         }
         if(sebre >= 1){
             System.out.printf("Sabre: %d%n",sebre);
         }
        if(katana >= 1){
            System.out.printf("Katana: %d%n",katana);
        }
        if(shamshir >= 1){
            System.out.printf("Shamshir: %d%n",shamshir);
        }
        if(gladius >= 1){
            System.out.printf("Gladius: %d%n",gladius);
        }

    }
}
