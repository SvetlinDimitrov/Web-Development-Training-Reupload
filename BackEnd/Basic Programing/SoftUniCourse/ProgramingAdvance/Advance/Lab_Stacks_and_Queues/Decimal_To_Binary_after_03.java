package JavaAdvance.Lab_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Decimal_To_Binary_after_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> nums = new ArrayDeque<>();

        while(num!= 0 ){
            nums.push(num % 2);
            num/=2;
        }
        nums.forEach(e-> System.out.printf("%d",e));
    }
}
