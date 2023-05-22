package JavaOOP.Encapsulation_Exercises.ClassBoxDataValidation_01;

import java.util.Scanner;

public class Box_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        try {
           Box box = new Box(length , width , height);
           System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
           System.out.printf("Lateral Surface Area - %.2f%n",box.calculateLateralSurfaceArea());
           System.out.printf("Volume – %.2f%n",box.calculateVolume());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
