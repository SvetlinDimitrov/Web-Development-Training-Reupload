package JavaAdvance.Lab_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> copy = new ArrayDeque<>();

        while(!input.equals("print")){
            if(input.equals("cancel")){
                if(copy.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.printf("Canceled %s%n",copy.poll());
                }
            }else{
                copy.offer(input);
            }
            input = scanner.nextLine();
        }
        for(String elem : copy){
            System.out.println(elem);
        }
    }
}
