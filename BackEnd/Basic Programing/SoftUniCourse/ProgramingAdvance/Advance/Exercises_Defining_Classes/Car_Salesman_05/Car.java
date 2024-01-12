package JavaAdvance.Exercises_Defining_Classes.Car_Salesman_05;

public class Car {
    private String model;
    private String engine;
    private int  weight;
    private String color;

    public String getModel() {
        return model;

    }

    public int getWeight() {
        return weight;
    }

    public String getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public Car(String model, String engine, int weight, String color) {
        this.model = model;
        this.weight = weight;
        this.engine = engine;
        this.color = color;
    }

    public Car(String model, String engine, int weight){
        this(model,engine,weight,"n/a");
    }
    public Car(String model, String engine, String color){
        this(model,engine,-1,color);
    }
    public Car(String model, String engine){
        this(model,engine,-1,"n/a");
    }

}
