package JavaAdvance.Exams.Java_Advanced_Exam22October2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Energy_Drinks_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> milligramsCoffee = new ArrayDeque<>();
        ArrayDeque<Integer> drinks = new ArrayDeque<>();

        int sumOfCoffee = 0;
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                .forEach(milligramsCoffee::push);

        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                .forEach(drinks::offerLast);

        while (!milligramsCoffee.isEmpty() && !drinks.isEmpty()) {
            int coffeeCurrent = milligramsCoffee.pop();
            int energyDrink = drinks.pollFirst();
            int sum = coffeeCurrent * energyDrink;

            if (sumOfCoffee + sum <= 300) {
                sumOfCoffee += sum;
            } else {
                drinks.offerLast(energyDrink);
                if(sumOfCoffee-30 < 0){
                    sumOfCoffee=0;
                }else {
                    sumOfCoffee -= 30;
                }
            }
        }
        if (!drinks.isEmpty()) {
            System.out.printf("Drinks left: %s%n",
                    drinks.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }else {
         System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.",sumOfCoffee);
    }
}
