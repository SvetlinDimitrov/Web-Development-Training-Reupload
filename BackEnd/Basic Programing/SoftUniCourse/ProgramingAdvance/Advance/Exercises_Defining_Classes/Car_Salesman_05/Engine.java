package JavaAdvance.Exercises_Defining_Classes.Car_Salesman_05;

public class Engine {
    private String model;
    private String power;
    private int displacement;
    private String efficiency;
    private Car car;

    public String getModel() {
        return model;
    }

    public String getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public Engine(String model, String power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
        this.car = null;

    }

    public Engine(String model, String power) {
        this(model,power,-1,"n/a");
        this.car = null;
    }

    public Engine(String model, String power, String efficiency) {
        this(model,power,-1,efficiency);
        this.car = null;
    }

    public Engine(String model, String power, int displacement) {
        this(model ,power,displacement , "n/a");
        this.car = null;
    }
    @Override
    public String toString() {
        return String.format("%s:%n" +
                        "%s:%n"+
                        "Power: %s%n"+
                        "Displacement: %s%n"+
                        "Efficiency: %s%n"
                        +"Weight: %s%n"
                        +"Color: %s%n",car.getModel(),car.getEngine(),getPower()
                ,getDisplacement()==-1 ? "n/a" : getDisplacement(),
                getEfficiency()
                ,car.getWeight() == -1 ? "n/a" : car.getWeight(),
                car.getColor()
        );
    }
}
