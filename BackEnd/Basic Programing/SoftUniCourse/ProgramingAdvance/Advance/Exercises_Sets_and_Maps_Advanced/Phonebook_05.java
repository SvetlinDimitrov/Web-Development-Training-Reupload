package JavaAdvance.Exercises_Sets_and_Maps_Advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String , String> map = new HashMap<>();

        while (!input.equals("search")){
            String name = input.split("-")[0];
            String number = input.split("-")[1];
            map.put(name , number);
            input= scanner.nextLine();
        }
        String secondInput = scanner.nextLine();
        while (!secondInput.equals("stop")){
            if(map.containsKey(secondInput)){
                System.out.printf("%s -> %s%n",secondInput , map.get(secondInput));
            }else{
                System.out.printf("Contact %s does not exist.%n",secondInput);
            }


            secondInput = scanner.nextLine();
        }
    }
}
