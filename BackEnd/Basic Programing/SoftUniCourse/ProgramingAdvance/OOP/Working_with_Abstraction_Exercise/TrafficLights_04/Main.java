package JavaOOP.Working_with_Abstraction_Exercise.TrafficLights_04;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrafficLight [] traffic = Arrays.stream(scanner.nextLine().split(" "))
                .map(Light::valueOf)
                .map(TrafficLight::new)
                .toArray(TrafficLight[]::new);

        int times = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < traffic.length; j++) {
                traffic[j].changeColor();
                System.out.printf("%s ",traffic[j].getLight());
            }
            System.out.println();
        }
    }
}
