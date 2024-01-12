package JavaAdvance.Lab_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input[] = scanner.nextLine().split(" ");
        Collections.reverse(Arrays.asList(input));
        ArrayDeque<String> calculate = new ArrayDeque<>();

        for(String element : input){
            calculate.push(element);
        }


        while(calculate.size() != 1){
            int firstNum = Integer.parseInt(calculate.pop());
            String elem = calculate.pop();
            int secondNum = Integer.parseInt(calculate.pop());
            int sum = 0;
            switch (elem){
                case "+":
                    sum = firstNum + secondNum;
                    break;
                case "-":
                    sum = firstNum - secondNum;
                    break;
            }
            calculate.push(sum + "");
        }
        System.out.println(calculate.pop());
    }
}
