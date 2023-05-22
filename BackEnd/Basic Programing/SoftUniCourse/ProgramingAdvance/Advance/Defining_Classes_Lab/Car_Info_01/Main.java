package JavaAdvance.Defining_Classes_Lab.Car_Info_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Car car = new Car();
        for (int i = 0; i < times; i++) {
            String input = scanner.nextLine();
            car.brand=input.split(" ")[0];
            car.model =input.split(" ")[1];
            car.horsePower=Integer.parseInt(input.split(" ")[2]);

            car.PrintCar();
        }


    }
}
