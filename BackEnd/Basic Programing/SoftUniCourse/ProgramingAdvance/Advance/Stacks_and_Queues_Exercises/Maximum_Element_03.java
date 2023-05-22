package JavaAdvance.Stacks_and_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Maximum_Element_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < times; i++) {
            int command = scanner.nextInt();
            switch (command){
                case 1:
                    int numToPush = scanner.nextInt();
                    numbers.push(numToPush);

                    break;
                case 2:
                    numbers.pop();

                    break;
                case 3:
                    System.out.println(Collections.max(numbers));

                    break;
            }
        }
    }
}
