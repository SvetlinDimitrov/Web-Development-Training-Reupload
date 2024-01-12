package JavaOOP.Working_with_Abstraction_Exercise.CardRank_02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine()+":");
        Arrays.stream(Cards.values()).forEach(e->System.out.printf("Ordinal value: %d; Name value: %s%n",e.ordinal(),e.name()));
    }
}
