package JavaAdvance.Defining_Classes_Lab.Car_Constructors_02;

public class Car {
    String brand;
    String model;
    int horsePower;

    public Car(String brand){
        this.brand = brand;
        model = "unknown";
        horsePower = -1;
    }

    public Car(String brand , String model , int horsePower){
        this.brand = brand;
        this.horsePower=horsePower;
        this.model=model;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",brand,model,horsePower);
    }
}
