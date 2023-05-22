package JavaOOP.Working_with_Abstraction_Exercise.CardsWithPower_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String card1 = scanner.nextLine();
        String card2 = scanner.nextLine();
        System.out.printf("Card name: %s of %s; Card power: %d",card1 , card2,Cards.valueOf(card1).getPower() + Cards.valueOf(card2).getPower());
    }
}
