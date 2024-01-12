package JavaAdvance.Lab_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Hot_Potato_after_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> que = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(que::offer);
        int intervalToPass = Integer.parseInt(scanner.nextLine());

        while(que.size() != 1){
            for (int i = 1; i <= intervalToPass; i++) {
                String save = que.pop();
                if(intervalToPass != i){
                    que.offer(save);
                }else{
                    System.out.printf("Removed %s%n", save);
                }
            }
        }
        System.out.printf("Last is %s",que.pop());
    }
}
