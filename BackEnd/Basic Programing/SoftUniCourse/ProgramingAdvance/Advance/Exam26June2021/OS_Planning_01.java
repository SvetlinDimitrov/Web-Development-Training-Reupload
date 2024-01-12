package JavaAdvance.Exams.Java_Advanced_Exam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OS_Planning_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer>tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(tasks::push);
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(threads::offerLast);
        int taskValue = Integer.parseInt(scanner.nextLine());

        while(!tasks.isEmpty() && !threads.isEmpty()){
            int task = tasks.pop();
            int thread = threads.pollFirst();

            if(task == taskValue ){
                System.out.printf("Thread with value %d killed task %d%n",thread,task);
                threads.offerFirst(thread);
                break;
            }
            if(!(thread >= task)){
                tasks.push(task);

            }

        }

        System.out.printf("%s",threads.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
