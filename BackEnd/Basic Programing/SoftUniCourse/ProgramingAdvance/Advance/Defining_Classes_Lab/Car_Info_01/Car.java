package JavaAdvance.Defining_Classes_Lab.Car_Info_01;

public class Car {
    public String brand;
    public String model;
    public int horsePower;

    public void PrintCar(){
        System.out.printf("The car is: %s %s - %d HP.%n",brand , model , horsePower);
    }
}
