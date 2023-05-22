package JavaAdvance.Lab_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Matching_Brackets_after_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> brackets = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if(letter == '('){
                brackets.push(i);
            }else if (letter == ')'){
                System.out.println(input.substring(brackets.pop() , i+1));
            }
        }
    }
}
