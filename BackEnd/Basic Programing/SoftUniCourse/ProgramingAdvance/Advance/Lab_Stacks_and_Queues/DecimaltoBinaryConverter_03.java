package JavaAdvance.Lab_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimaltoBinaryConverter_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();

        while(input>0){
            if(input%2==0){
                binary.push(0);
            }else{
                binary.push(1);
            }
            input/=2;
        }
        for (Integer num : binary){
            System.out.printf("%d",num);
        }
    }
}
