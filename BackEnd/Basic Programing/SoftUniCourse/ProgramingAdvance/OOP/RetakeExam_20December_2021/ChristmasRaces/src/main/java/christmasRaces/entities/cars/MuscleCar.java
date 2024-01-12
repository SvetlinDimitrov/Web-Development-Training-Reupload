package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar{
    private final static double MINIMUM_CUBIC_CENTIMETERS = 5000;
    private final static double MINIMUM_HORSEPOWER = 400;
    private final static double MAXIMUM_HORSEPOWER = 600;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, MINIMUM_CUBIC_CENTIMETERS);
        boolean isValid = horsePower >= MINIMUM_HORSEPOWER && horsePower <= MAXIMUM_HORSEPOWER;
        if (!isValid) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
    }
}
