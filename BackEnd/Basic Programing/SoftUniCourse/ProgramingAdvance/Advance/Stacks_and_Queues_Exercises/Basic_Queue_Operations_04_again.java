package JavaAdvance.Stacks_and_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Basic_Queue_Operations_04_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int push = numbers[0];
        int pop = numbers[1];
        int numberToFind = numbers[2];
        int[] input  = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int count =1;

        Push(push , stack , input);
        Pop(pop , stack);
        if(stack.contains(numberToFind)){
            System.out.println("true");
        }else if (!stack.isEmpty()){
            System.out.println(Collections.min(stack));
        }else{
            System.out.println(0);
        }

    }
    public static void Push(int num , ArrayDeque<Integer> stack, int [] arr ){
        int sum  = 1;
        for (int j : arr) {
            if (sum == num) {
                break;
            } else {
                stack.offer(j);
            }
        }
    }
    public static void Pop(int num , ArrayDeque<Integer> stack ){
        for (int i = 0; i < num; i++) {
            stack.poll();
        }
    }
}
