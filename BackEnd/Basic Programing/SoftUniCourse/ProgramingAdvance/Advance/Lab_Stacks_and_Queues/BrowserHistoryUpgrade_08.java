package JavaAdvance.Lab_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> back = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();
        String input = scanner.nextLine();
        String page = "blank";

        while (!input.equals("Home")) {
            switch (input) {
                case "forward":
                    if (forward.isEmpty()) {
                        System.out.println("no next URLs");
                    } else {
                        back.push(page);
                        page = forward.poll();
                        System.out.println(page);
                    }
                    break;
                case "back":
                    if (back.isEmpty()) {
                        System.out.println("no previous URLs");
                    } else {
                        forward.push(page);
                        page = back.poll();
                        System.out.println(page);
                    }
                    break;
                default:
                    if (!page.equals("blank")) {
                        back.push(page);
                    }
                    page = input;
                    System.out.println(page);
            }
            input = scanner.nextLine();
        }
    }
}
