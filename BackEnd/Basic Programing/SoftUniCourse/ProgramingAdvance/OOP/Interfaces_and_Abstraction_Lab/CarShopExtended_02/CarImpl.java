public class CarImpl implements Car {

    private String model;
    private String color;
    private Integer horsePower;
    private String city;

    public CarImpl(String model, String color, Integer horsePower, String city) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.city = city;
    }

    @Override
    public String getModel() {
        return null;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public Integer getHorsePower() {
        return null;
    }

    @Override
    public String countryProduced() {
        return null;
    }

    @Override
    public String toString() {
        return "CarImpl{}";
    }
}
