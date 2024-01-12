package JavaAdvance.Exercises_Defining_Classes.Speed_Racing_03;

public class Car {
    private String model;
    private double fuel;
    private double fuelCost;
    private int distance;

    public Car(String name , double fuel , double fuelCost ){
        this.model = name;
        this.fuel = fuel;
        this.fuelCost = fuelCost;
        distance =0;
    }

    public void Drive(int distance){
        if(distance * this.fuelCost > fuel){
            System.out.println("Insufficient fuel for the drive");
        }else{
            this.fuel -= distance * this.fuelCost;
            this.distance += distance;
        }
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getModel(){
        return model;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public int getDistance() {
        return distance;
    }
}
