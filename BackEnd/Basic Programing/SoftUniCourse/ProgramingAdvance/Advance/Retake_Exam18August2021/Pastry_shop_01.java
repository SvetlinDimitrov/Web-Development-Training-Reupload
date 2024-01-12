package JavaAdvance.Exams.Java_Advanced_Retake_Exam18August2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pastry_shop_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer>liquids = new ArrayDeque<>();
        ArrayDeque<Integer>ingredients = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .forEach(liquids::offerLast);
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .forEach(ingredients::push);

        int biscuit = 0;
        int cake = 0;
        int pastry = 0;
        int pie = 0;

        int sum =0;
        while(!liquids.isEmpty() && !ingredients.isEmpty()){
            int singleLiquid = liquids.pollFirst();
            int singleIngredient = ingredients.pop();
            sum = singleIngredient+singleLiquid;
            switch (sum){
                case 25:
                    biscuit++;
                    break;
                case 50:
                    cake++;
                    break;
                case 75:
                    pastry++;
                    break;
                case 100:
                    pie++;
                    break;
                default:
                    ingredients.push(singleIngredient+3);
            }
        }
        if(biscuit != 0 && cake !=0 && pastry !=0 && pie !=0){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if(liquids.isEmpty()){
            System.out.println("Liquids left: none");
        }else{
           System.out.printf("Liquids left: %s%n",
                   liquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if(ingredients.isEmpty()){
            System.out.println( "Ingredients left: none");
        }else{
            System.out.printf("Ingredients left: %s%n",
                    ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.printf("Biscuit: %d%n",biscuit);
        System.out.printf("Cake: %d%n",cake);
        System.out.printf("Pie: %d%n",pie);
        System.out.printf("Pastry: %d%n",pastry);
    }
}
