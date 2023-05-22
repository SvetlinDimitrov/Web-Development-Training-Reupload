package JavaAdvance.Exercises_Sets_and_Maps_Advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , String> map = new HashMap<>();
        String input = scanner.nextLine();
        while(!input.equals("search")){
            String name = input.split("-")[0];
            String number = input.split("-")[1];
            map.putIfAbsent(name , number);
            input= scanner.nextLine();
        }

        String input2 = scanner.nextLine();
        while(!input2.equals("stop")){
            if(map.containsKey(input2)){
                System.out.printf("%s -> %s%n",input2 , map.get(input2));
            }else{
                System.out.printf("Contact %s does not exist.%n",input2);
            }

            input2= scanner.nextLine();
        }
    }
}
