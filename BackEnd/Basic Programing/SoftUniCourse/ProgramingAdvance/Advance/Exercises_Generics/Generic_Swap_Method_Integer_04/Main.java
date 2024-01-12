package JavaAdvance.Exercises_Generics.Generic_Swap_Method_Integer_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();
        for (int i = 0; i <times ; i++) {
            box.add(Integer.parseInt(scanner.nextLine()));
        }
        int swap1 = scanner.nextInt();
        int swap2 = scanner.nextInt();

        box.swap(swap1 ,swap2);

        System.out.println(box);
    }
}
