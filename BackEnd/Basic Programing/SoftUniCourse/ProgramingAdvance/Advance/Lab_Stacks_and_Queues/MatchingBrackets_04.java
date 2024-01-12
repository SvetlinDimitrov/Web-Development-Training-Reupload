package JavaAdvance.Lab_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            switch (letter){
                case'(':
                    que.push(i);
                    break;
                case')':
                    int lastBracket = que.pop();
                    String allInBrackets = input.substring(lastBracket , i+1);
                    System.out.println(allInBrackets);
                    break;
            }
        }
    }
}
