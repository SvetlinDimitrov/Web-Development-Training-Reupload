package JavaAdvance.Stacks_and_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Balanced_Parentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> bracket = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            switch (currentSymbol) {
                case '(':
                case '{':
                case '[':
                    bracket.push(currentSymbol);
                    break;
                case ')':
                    if (bracket.pop() != '(') {
                        System.out.println("NO");
                        return;
                    }
                    break;
                case '}':
                    if (bracket.pop() != '{') {
                        System.out.println("NO");
                        return;
                    }
                    break;
                case ']':
                    if (bracket.pop() != '[') {
                        System.out.println("NO");
                        return;
                    }
                    break;
            }
        }

            System.out.println("YES");

    }
}
