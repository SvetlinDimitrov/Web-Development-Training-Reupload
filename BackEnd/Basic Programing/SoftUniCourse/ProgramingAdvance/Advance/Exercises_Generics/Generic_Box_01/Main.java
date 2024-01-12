package JavaAdvance.Exercises_Generics.Generic_Box_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());

        Box <String>box= new Box<>();
        for (int i = 0; i < times; i++) {
            input = scanner.nextLine();
            box.add(input);
        }
        System.out.println(box.toString());
    }
}
