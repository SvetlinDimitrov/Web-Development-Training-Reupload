package JavaAdvance.Stacks_and_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Reverse_Numbers_with_a_Stack_01_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" ")).forEach(stack::push);
        stack.forEach(e-> System.out.printf("%s ",e));
    }
}
