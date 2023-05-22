package JavaAdvance.Exercises_Defining_Classes.Raw_Data_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        int timesToRead = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < timesToRead; i++) {
            String [] input = scanner.nextLine().split(" ");

            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            double tire1age = Double.parseDouble(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            double tire2age = Double.parseDouble(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            double tire3age = Double.parseDouble(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            double tire4age = Double.parseDouble(input[12]);

            cars.add(new Car(model , engineSpeed ,enginePower,cargoWeight,cargoType,tire1Pressure,tire1age
            ,tire2Pressure,tire2age,tire3Pressure,tire3age,tire4Pressure,tire4age));
        }
        String condition = scanner.nextLine();
        if(condition.equals("fragile")){
            cars.stream().filter(e ->e.getCargoType().equals("fragile"))
                    .filter(e-> e.getTire1Pressure() < 1 && e.getTire2Pressure() < 1 &&
                            e.getTire3Pressure() < 1 && e.getTire4Pressure() < 1)
                    .forEach(e->System.out.println(e.getModel()));
        }else if(condition.equals("flamable")){
            cars.stream().filter(e ->e.getCargoType().equals("flamable"))
                    .filter(e-> e.getEnginePower() > 250)
                    .forEach(e->System.out.println(e.getModel()));
        }
    }
}
