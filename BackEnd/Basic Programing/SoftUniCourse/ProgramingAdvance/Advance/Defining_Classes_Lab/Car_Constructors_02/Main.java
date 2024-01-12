package JavaAdvance.Defining_Classes_Lab.Car_Constructors_02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String [] input;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <times ; i++) {
            input = Arrays.stream(scanner.nextLine().split(" ")).toArray(String[]::new);
            if(input.length == 1){
                Car car = new Car(input[0]);
                System.out.println(car);
            }else{
                Car car = new Car(input[0],input[1],Integer.parseInt(input[2]));
                System.out.println(car);
            }

        }
    }
}
