package JavaAdvance.Lab_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Printer_Queue_after_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = scanner.nextLine();

        while(!input.equals("print")){
            if(!input.equals("cancel")){
                stack.offer(input);
            }else{
                if(stack.isEmpty()){
                    System.out.println("Printer is on standby");
                }else{
                    System.out.printf("Canceled %s%n",stack.poll());
                }
            }
            input = scanner.nextLine();
        }
        stack.forEach(System.out::println);
    }
}
