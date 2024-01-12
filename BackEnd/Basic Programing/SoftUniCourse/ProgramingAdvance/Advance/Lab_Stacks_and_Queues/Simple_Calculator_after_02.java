package JavaAdvance.Lab_Stacks_and_Queues;

import java.util.*;

public class Simple_Calculator_after_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] chars = scanner.nextLine().split(" ");
        ArrayDeque<String> original = new ArrayDeque<>();
        ArrayDeque<String> letters = new ArrayDeque<>();

        Arrays.stream(chars).forEach(original::push);
        original.forEach(letters::push);

        int sum = 0;
        int firstNum = 0;
        int secondNum = 0;

        while(!letters.isEmpty()){
            String word = letters.pop();
            if(Character.isDigit(word.charAt(0))){
                firstNum = Integer.parseInt(word);
            }
            if(word.equals("+") || word.equals("-")){
                switch (word){
                    case "+":
                        secondNum = Integer.parseInt(letters.pop());
                        sum = firstNum + secondNum;
                        letters.push(sum + "");
                        break;
                    case "-":
                        secondNum = Integer.parseInt(letters.pop());
                        sum =  firstNum - secondNum;
                        letters.push(sum + "");
                }
            }
        }
        System.out.println(sum);
    }
}
