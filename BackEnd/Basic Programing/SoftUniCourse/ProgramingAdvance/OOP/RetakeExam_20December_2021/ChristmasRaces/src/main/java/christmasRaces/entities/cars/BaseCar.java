package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car{
    private String model ;
    private int horsePower;
    private double cubicCentimeters;

    private void setModel(String model) {
        if(null == model || model.trim().length() < 4){
            throw new IllegalArgumentException(String.format(INVALID_MODEL,model , 4));
        }
        this.model = model;
    }

    protected BaseCar(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        this.horsePower = horsePower;
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return cubicCentimeters/ horsePower*laps;
    }
}
