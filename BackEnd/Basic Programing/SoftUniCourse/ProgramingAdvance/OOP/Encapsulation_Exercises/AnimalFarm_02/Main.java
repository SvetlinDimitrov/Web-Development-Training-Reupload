package JavaOOP.Encapsulation_Exercises.AnimalFarm_02;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        try{
            Chicken chicken = new Chicken(name , age);
            System.out.print(chicken);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
