package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar{

    private final static double MINIMUM_CUBIC_CENTIMETERS = 3000;
    private final static double MINIMUM_HORSEPOWER = 250;
    private final static double MAXIMUM_HORSEPOWER = 450;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, MINIMUM_CUBIC_CENTIMETERS);
        boolean isValid = horsePower >= MINIMUM_HORSEPOWER && horsePower <= MAXIMUM_HORSEPOWER;
        if (!isValid) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
    }
}
