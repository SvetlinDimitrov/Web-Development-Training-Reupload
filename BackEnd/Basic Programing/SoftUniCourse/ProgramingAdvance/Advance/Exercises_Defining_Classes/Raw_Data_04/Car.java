package JavaAdvance.Exercises_Defining_Classes.Raw_Data_04;

public class Car {
    private  String model;
    private  int engineSpeed;
    private  int enginePower;
    private  int cargoWeight;
    private  String cargoType;
    private double tire1Pressure;
    private double tire1Age;
    private double tire2Pressure;
    private double tire2Age;
    private double tire3Pressure;
    private double tire3Age;
    private double tire4Pressure;
    private double tire4Age;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType
            , double tire1Pressure, double tire1Age, double tire2Pressure, double tire2Age
            , double tire3Pressure, double tire3Age, double tire4Pressure, double tire4Age) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tire1Pressure = tire1Pressure;
        this.tire1Age = tire1Age;
        this.tire2Pressure = tire2Pressure;
        this.tire2Age = tire2Age;
        this.tire3Pressure = tire3Pressure;
        this.tire3Age = tire3Age;
        this.tire4Pressure = tire4Pressure;
        this.tire4Age = tire4Age;
    }

    public String getCargoType(){
        return cargoType;
    }

    public String getModel() {
        return model;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public double getTire1Pressure() {
        return tire1Pressure;
    }

    public double getTire1Age() {
        return tire1Age;
    }

    public double getTire2Pressure() {
        return tire2Pressure;
    }

    public double getTire2Age() {
        return tire2Age;
    }

    public double getTire3Pressure() {
        return tire3Pressure;
    }

    public double getTire3Age() {
        return tire3Age;
    }

    public double getTire4Pressure() {
        return tire4Pressure;
    }

    public double getTire4Age() {
        return tire4Age;
    }
}
