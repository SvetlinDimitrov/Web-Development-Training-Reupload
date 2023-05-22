package JavaOOP.Working_with_Abstraction_Lab.HotelReservation_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] words = scanner.nextLine().split(" ");
        double price = Double.parseDouble(words[0]);
        int days = Integer.parseInt(words[1]);
        System.out.printf("%.2f",PriceCalculator.MoneyToPay(price,days,words[2],words[3]));
    }
}
