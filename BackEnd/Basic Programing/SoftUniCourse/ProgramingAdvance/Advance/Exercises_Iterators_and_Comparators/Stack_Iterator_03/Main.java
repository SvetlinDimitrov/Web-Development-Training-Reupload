package JavaAdvance.Exercises_Iterators_and_Comparators.Stack_Iterator_03;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String  input = scanner.nextLine();
        Stack stack = new Stack<>();

        while(!input.equals("END")){
            if(input.contains("Push")){
                for (int i = 0; i < input.length(); i++) {
                    if(Character.isDigit(input.charAt(i))){
                        stack.push(input.charAt(i));
                    }
                }
            }else if (input.equals("Pop")){
                stack.pop();
            }
            System.out.println();
            input = scanner.nextLine();
        }
       stack.forEach(e->System.out.println(e));
    }
}
