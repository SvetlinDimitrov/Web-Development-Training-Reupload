package JavaAdvance.Exams.Java_Advanced_Retake_Exam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                .forEach(tulips::push);
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                .forEach(daffodils::offerLast);
        int countFlowers =0;
        int sum =0;
        int storeSum =0;
        while(!daffodils.isEmpty() && !tulips.isEmpty()){
            int tulip = tulips.pop();
            int daff = daffodils.pollFirst();
            sum = daff +tulip;
            if(sum >15){
                tulips.push(tulip-2);
                daffodils.offerFirst(daff);
            }else if (sum<15){
                storeSum +=sum;
            }else{
                countFlowers++;
            }
        }
        countFlowers+=storeSum/15;
        if(countFlowers >=5){
            System.out.printf("You made it! You go to the competition with %d bouquets!%n",countFlowers);
        }else{
            System.out.printf("You failed... You need more %d bouquets.",5-countFlowers);
        }
    }
}
