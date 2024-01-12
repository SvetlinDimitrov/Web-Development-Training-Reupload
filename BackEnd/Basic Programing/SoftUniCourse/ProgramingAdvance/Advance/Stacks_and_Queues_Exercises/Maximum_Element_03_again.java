package JavaAdvance.Stacks_and_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Maximum_Element_03_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < times; i++) {
            int [] input = Arrays.stream(scanner.nextLine().split(" ")).
                    mapToInt(Integer::parseInt)
                    .toArray();

            switch (input[0]){
                case 1:
                    stack.push(input[1]);
                    break;
                case 2 :
                    stack.pop();
                    break;
                case 3 :
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
