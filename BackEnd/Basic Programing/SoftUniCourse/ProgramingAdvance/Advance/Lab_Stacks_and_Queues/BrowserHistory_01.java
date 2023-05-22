package JavaAdvance.Lab_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> que = new ArrayDeque<>();
        String now = "blank";

        while (!input.equals("Home")) {
            if(input.equals("back")){
                if(!que.isEmpty()) {
                    now = que.pop();
                }else{
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            }else{
                if(!now.equals("blank")){
                    que.push(now);
                }
                now = input;
            }
            System.out.println(now);
            input = scanner.nextLine();
        }
    }
}

