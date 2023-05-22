package JavaAdvance.Stacks_and_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Simple_Text_Editor_07 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int commands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < commands; i++) {
            String input = scanner.nextLine();
            int command = Integer.parseInt(input.split(" ")[0]);

            if (command == 1 || command == 2){
                stack.push(word.toString());
            }
            if(command == 1){
                String appendWord = input.split(" ")[1];
                word.append(appendWord);

            }else if ( command == 2){
                int wordToDelete = Integer.parseInt(input.split(" ")[1]);
                for (int j = 0; j < wordToDelete; j++) {
                    word.deleteCharAt(word.length()-1);
                }
            }else if (command == 3){
                int print = Integer.parseInt(input.split(" ")[1]);
                if(word.toString().length() >= print){
                    System.out.printf("%c%n",word.toString().charAt(print - 1));
                }
            }else if (command == 4){
                String newWord = stack.pop();
                word.delete(0, word.length());
                word.append(newWord);
            }
        }

    }
}
