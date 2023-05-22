package christmasRaces.entities.drivers;

import christmasRaces.entities.cars.Car;

import static christmasRaces.common.ExceptionMessages.CAR_INVALID;
import static christmasRaces.common.ExceptionMessages.INVALID_NAME;

public class DriverImpl implements Driver{
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    private void setName(String name) {
        if(name == null || name.trim().length() < 5){
            throw new IllegalArgumentException(String.format(INVALID_NAME,name , 5));
        }
        this.name = name;
    }

    public DriverImpl(String name) {
        setName(name);
        this.car = null;
        this.canParticipate = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if(null != car){
            this.car = car;
            canParticipate = true;
            return;
        }
        throw new IllegalArgumentException(CAR_INVALID);
    }

    @Override
    public void winRace() {
        numberOfWins+=1;
    }

    @Override
    public boolean getCanParticipate() {
        return canParticipate;
    }
}
