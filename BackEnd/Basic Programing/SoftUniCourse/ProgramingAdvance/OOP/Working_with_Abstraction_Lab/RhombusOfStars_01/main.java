package JavaOOP.Working_with_Abstraction_Lab.RhombusOfStars_01;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int toPrint = 1;
        int times= Integer.parseInt(scanner.nextLine());
        int countToPass = Math.abs(1-times);

        for (int i = 0; i < times; i++) {
            for (int j = 0; j < countToPass; j++) {
                System.out.print(" ");
            }
            countToPass--;
            for (int j = 0; j < toPrint; j++) {
                System.out.print("* ");
            }
            toPrint++;
            System.out.println();
        }

        countToPass = toPrint - times;
        for (int i = 0; i <times-1 ; i++) {
            toPrint = (times-1) - i;
            for (int j = 0; j < countToPass; j++) {
                System.out.print(" ");
            }
            countToPass++;
            for (int j = 0; j < toPrint; j++) {
             System.out.print("* ");
            }
            System.out.println();
        }
    }
}
