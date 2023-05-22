public class Seat extends CarImpl implements Sellable{
    private String model;
    private String color;
    private Integer horsePower;
    private String city;

    private Double price;

    public Seat(String model, String color, Integer horsePower, String city , Double price) {
        super(model, color, horsePower, city);
        this.price = price;
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

    @Override
    public Double getPrice() {
        return price;
    }
}
