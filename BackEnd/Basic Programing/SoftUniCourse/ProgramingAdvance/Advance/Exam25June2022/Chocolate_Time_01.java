package JavaAdvance.Exams.Java_Advanced_Exam25June2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Chocolate_Time_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Double> milk = new ArrayDeque<>();
        ArrayDeque<Double> cacao = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                 .map(Double::parseDouble)
                 .forEach(milk::offer);

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .forEach(cacao::push);

        int bakingChocolate =0;
        int darkChocolate =0;
        int milkChocolate=0;

        while(!milk.isEmpty() && !cacao.isEmpty()){
            double doubleMilk = milk.pollFirst();
            double doubleCacao = cacao.pop();

            int sum = (int) ((doubleCacao / (doubleMilk+doubleCacao))*100);
            if(sum == 100 || sum==30 || sum ==50){
                switch (sum){
                    case 100:
                        bakingChocolate++;
                        break;
                    case 30:
                        milkChocolate++;
                        break;
                    case 50:
                        darkChocolate++;
                        break;
                }
            }else{
                milk.offerLast(doubleCacao+10);
            }
        }

        if(bakingChocolate != 0 && darkChocolate != 0 && milkChocolate != 0){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            System.out.printf("# Baking Chocolate --> %d%n",bakingChocolate);
            System.out.printf("# Dark Chocolate --> %d%n",darkChocolate);
            System.out.printf("# Milk Chocolate --> %d%n",milkChocolate);
        }else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
            if (bakingChocolate != 0) {
                System.out.printf("# Baking Chocolate --> %d%n", bakingChocolate);
            }
            if (darkChocolate != 0) {
                System.out.printf("# Dark Chocolate --> %d%n", darkChocolate);
            }
            if (milkChocolate != 0) {
                System.out.printf("# Milk Chocolate --> %d%n", milkChocolate);
            }
        }
    }
}
