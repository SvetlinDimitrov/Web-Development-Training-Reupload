package JavaAdvance.Exercises_Defining_Classes.Google_07;

public class Car {
    private String carName;
    private int carSpeed;

    public Car(String carName, int carSpeed) {
        this.carName = carName;
        this.carSpeed = carSpeed;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarSpeed() {
        return carSpeed;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarSpeed(int carSpeed) {
        this.carSpeed = carSpeed;
    }
}
