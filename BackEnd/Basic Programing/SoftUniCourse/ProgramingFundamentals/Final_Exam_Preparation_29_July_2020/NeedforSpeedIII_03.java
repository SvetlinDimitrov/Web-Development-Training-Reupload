package ProgramingFundamentalsJava.Final_Exam_Preparation_29_July_2020;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedforSpeedIII_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cars = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> carMil = new LinkedHashMap<>();
        Map<String, Integer> carFuel = new LinkedHashMap<>();

        for (int i = 0; i < cars; i++) {
            //"{car}|{mileage}|{fuel}"
            String input = scanner.nextLine();
            String car = input.split("\\|")[0];
            int mileage = Integer.parseInt(input.split("\\|")[1]);
            int fuel = Integer.parseInt(input.split("\\|")[2]);
            carMil.put(car, mileage);
            carFuel.put(car, fuel);
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String command = input.split(" : ")[0];
            //· "Drive : {car} : {distance} : {fuel}":
            if (command.equals("Drive")) {
                String car = input.split(" : ")[1];
                int distance = Integer.parseInt(input.split(" : ")[2]);
                int fuel = Integer.parseInt(input.split(" : ")[3]);
                if (carFuel.containsKey(car)) {
                    if (fuel <= carFuel.get(car)) {
                        int currentFuel = carFuel.get(car);
                        carFuel.put(car, currentFuel - fuel);
                        int currentMile = carMil.get(car);
                        carMil.put(car, currentMile + distance);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                        if (carMil.get(car) >= 100000) {
                            System.out.printf("Time to sell the %s!%n", car);
                            carMil.remove(car);
                            carFuel.remove(car);
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                }
            }else if (command.equals("Refuel")) {
                //"Refuel : {car} : {fuel}":
                String car = input.split(" : ")[1];
                int fuel = Integer.parseInt(input.split(" : ")[2]);
                if (carFuel.containsKey(car) && fuel >=0) {
                    int fuelToGive = FuelToGive(carFuel.get(car), fuel);
                    int currentFuelCar = carFuel.get(car);
                    carFuel.put(car , currentFuelCar+fuelToGive);
                    System.out.printf("%s refueled with %d liters%n",car , fuelToGive);
                }
            }else if (command.equals("Revert")){
                //"Revert : {car} : {kilometers}":
                String car = input.split(" : ")[1];
                int mile = Integer.parseInt(input.split(" : ")[2]);
                if(carMil.containsKey(car)){
                    int currentMile = carMil.get(car);
                    carMil.put(car , currentMile - mile);
                    if(carMil.get(car) < 10000){
                        carMil.put(car , 10000);
                    }else{
                        System.out.printf("%s mileage decreased by %d kilometers%n",car,mile);
                    }
                }
            }
            input = scanner.nextLine();
        }
        for(Map.Entry<String , Integer > entryMile :carMil.entrySet()){
            for(Map.Entry<String , Integer > entryFuel :carFuel.entrySet()) {
                if (entryFuel.getKey().equals(entryMile.getKey())) {
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entryFuel.getKey(), entryMile.getValue(), entryFuel.getValue());
                    break;
                }
            }
        }
    }

    private static int FuelToGive(Integer carFuel, int fuel) {
        int fuelCount = carFuel;
        while(true){
            if(fuel == 0){
                break;
            }
            if(fuelCount == 75){
                break;
            }
            fuelCount++;
            fuel--;
        }
        return fuelCount-carFuel;
    }
}
