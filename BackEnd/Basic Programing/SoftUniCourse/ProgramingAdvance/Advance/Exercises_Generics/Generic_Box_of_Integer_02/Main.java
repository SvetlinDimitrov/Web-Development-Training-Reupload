package JavaAdvance.Exercises_Generics.Generic_Box_of_Integer_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Box<Integer> newBox = new Box<>();
        for (int i = 0; i < times; i++) {
            newBox.add(Integer.parseInt(scanner.nextLine()));
        }
        System.out.println(newBox.toString());
    }
}
