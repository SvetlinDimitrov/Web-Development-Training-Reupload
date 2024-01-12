package JavaAdvance.Stacks_and_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Reverse_Numbers_with_Stack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers [] = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int number : numbers) {
            stack.push(number);
        }
        for (Integer integer : stack) {
            System.out.printf("%d ",integer);
        }
    }
}
