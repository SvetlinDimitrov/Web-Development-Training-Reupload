public class Seat implements  Car {
    private String model;
    private String color;
    private Integer horsePower;
    private String city;

    public Seat(String model, String color, Integer horsePower, String city) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.city = city;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String countryProduced() {
        return city;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires",
                getModel(),
                countryProduced(),
                TIRES);
    }
}
