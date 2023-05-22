package JavaAdvance.Lab_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Browser_History_01_after {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> history = new ArrayDeque<>();
        String url = " ";
        while(!input.equals("Home")){
            if(input.equals("back")){
                if(history.isEmpty()){
                    System.out.println("no previous URLs");
                }else{
                    url = history.pop();
                    System.out.println(url);
                }
            }else{
                if(url.equals(" ")){
                    url = input;
                }else{
                    history.push(url);
                    url=input;
                }
                System.out.println(url);
            }
            input= scanner.nextLine();
        }
    }
}
