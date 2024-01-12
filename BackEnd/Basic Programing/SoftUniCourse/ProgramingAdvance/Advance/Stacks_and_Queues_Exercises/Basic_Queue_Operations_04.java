package JavaAdvance.Stacks_and_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Basic_Queue_Operations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int addNum = scanner.nextInt();
        int deleteNum = scanner.nextInt();
        int checkNum = scanner.nextInt();
        ArrayDeque<Integer> stackNum = new ArrayDeque<>();

        for (int i = 0; i < addNum; i++) {
            int numToAdd = scanner.nextInt();
            stackNum.offer(numToAdd);
        }
        if (deleteNum <= stackNum.size()) {
            for (int i = 0; i < deleteNum; i++) {
                stackNum.poll();
            }
        }
        if (stackNum.contains(checkNum)) {
            System.out.println("true");
        } else if (stackNum.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(stackNum));
        }
    }
}
