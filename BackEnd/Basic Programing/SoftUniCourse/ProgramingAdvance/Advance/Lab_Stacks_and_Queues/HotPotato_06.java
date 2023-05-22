package JavaAdvance.Lab_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String peoples [] = scanner.nextLine().split(" ");
        ArrayDeque<String> group = new ArrayDeque<>();

        for(String person : peoples){
            group.offer(person);
        }

        int count = Integer.parseInt(scanner.nextLine());
        while(group.size() != 1){
            for (int i = 1; i < count; i++) {
                String save = group.poll();
                group.offer(save);
            }
            System.out.printf("Removed %s%n",group.pop());
        }
        System.out.printf("Last is %s",group.pop());
    }
}
