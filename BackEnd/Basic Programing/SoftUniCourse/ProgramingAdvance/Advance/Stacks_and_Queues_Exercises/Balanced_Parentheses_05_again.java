package JavaAdvance.Stacks_and_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Balanced_Parentheses_05_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character>stack = new ArrayDeque<>();
        ArrayDeque<Character>que = new ArrayDeque<>();
        char [] brackets = scanner.nextLine().toCharArray();

        for (int i = 0; i < brackets.length; i++) {
            if(brackets[i] == '{' || brackets[i] == '[' || brackets[i]== '('){
                stack.push(brackets[i]);
            }else if (brackets[i] == '}' || brackets[i] == ']' || brackets[i]== ')'){
                que.offer(brackets[i]);
            }
        }
        boolean valid = true;
        if(stack.size() != que.size()){
            System.out.println("No");
        }else{
            for (int i = 0; i < que.size(); i++) {
                char stackLetter = stack.pop();
                char queLetter = que.poll();
                if((stackLetter == '(' && queLetter == ')') ||
                        (stackLetter == '{' && queLetter == '}') ||
                        (stackLetter == '[' && queLetter == ']')){
                }else{
                    valid = false;
                    break;
                }
            }
            if(valid){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
