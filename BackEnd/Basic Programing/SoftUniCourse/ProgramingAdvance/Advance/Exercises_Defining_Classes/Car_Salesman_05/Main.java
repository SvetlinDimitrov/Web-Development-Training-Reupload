package JavaAdvance.Exercises_Defining_Classes.Car_Salesman_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int timesToRead;
    public static String[] input;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Engine> engineList = new ArrayList<>();
        List<Car> carLists = new ArrayList<>();

        timesToRead = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < timesToRead; i++) {
            input = scanner.nextLine().split(" ");
            switch (input.length){
                case 4:
                    engineList.add(new Engine(input[0],input[1],Integer.parseInt(input[2]),input[3]));
                    break;
                case 3:
                    try{
                        engineList.add(new Engine(input[0],input[1],Integer.parseInt(input[2])));
                    }catch (Exception e){
                        engineList.add(new Engine(input[0],input[1],input[2]));
                    }
                    break;
                case 2:
                    engineList.add(new Engine(input[0],input[1]));
                    break;
            }
        }

        timesToRead = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < timesToRead; i++) {
            input = scanner.nextLine().split(" ");
            switch (input.length){
                case 4:
                    carLists.add(new Car(input[0],input[1],Integer.parseInt(input[2]),input[3]));
                    break;
                case 3:
                    try{
                        carLists.add(new Car(input[0],input[1],Integer.parseInt(input[2])));
                    }catch (Exception e){
                        carLists.add(new Car(input[0],input[1],input[2]));
                    }
                    break;
                case 2:
                    carLists.add(new Car(input[0],input[1]));
            }
        }

        for (Car carList : carLists) {
            engineList.stream().filter(engine-> engine.getModel()
                            .equals(carList.getEngine()))
                    .forEach(e-> {System.out.printf("%s",
                        String.format("%s:%n" +
                                "%s:%n"+
                                "Power: %s%n"+
                                "Displacement: %s%n"+
                                "Efficiency: %s%n"
                                +"Weight: %s%n"
                                +"Color: %s%n"
                        ,carList.getModel()
                        ,carList.getEngine()
                        ,e.getPower()
                        ,e.getDisplacement() == -1 ? "n/a" : e.getDisplacement()
                        ,e.getEfficiency()
                        ,carList.getWeight() == -1 ? "n/a" : carList.getWeight()
                        ,carList.getColor()));
                    });
        }
    }
}
