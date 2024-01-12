package JavaAdvance.Exercises_Generics.Generic_Swap_Method_String_03;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Box<String> newBox = new Box<>();

        for (int i = 0; i < times; i++) {
            newBox.add(scanner.nextLine());
        }
        int swap1 = scanner.nextInt();
        int swap2 = scanner.nextInt();
        newBox.swap(swap1 , swap2);
        System.out.println(newBox);
    }
}
