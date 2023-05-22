package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Applied_Arithmetics_04_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        Consumer<String []> print = e-> System.out.println(String.join(" " ,e));
        while(!input.equals("end")){
             switch (input){
                 case"add":
                     arr = Arrays.stream(arr).map(e->e+1).toArray();
                     break;
                 case"subtract":
                     arr = Arrays.stream(arr).map(e->e-1).toArray();
                     break;
                 case"multiply":
                     arr = Arrays.stream(arr).map(e->e*2).toArray();
                     break;
                 case"print":
                     print.accept(Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new));
                     break;
             }

            input = scanner.nextLine();
        }
    }
}
