package JavaAdvance.Exercises_Defining_Classes.Speed_Racing_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String[] input;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < times; i++) {
            input = scanner.nextLine().split(" ");
            cars.add(new Car(input[0],Integer.parseInt(input[1]) , Double.parseDouble(input[2])));
        }
        input = scanner.nextLine().split(" ");
        while(!input[0].equals("End")){
            if(input[0].equals("Drive")){
                for (int i = 0; i < cars.size(); i++) {
                    if(cars.get(i).getModel().equals(input[1])){
                        cars.get(i).Drive(Integer.parseInt(input[2]));
                        break;
                    }
                }
            }
            input = scanner.nextLine().split(" ");
        }
        cars.stream().forEach(e-> System.out.printf("%s %.2f %d%n",e.getModel(),e.getFuel(),e.getDistance()));
    }
}
