package JavaOOP.Working_with_Abstraction_Lab.HotelReservation_04;

public enum Discount {
    VIP(20),
    SecondVisit(10),
    None(0);
    private double percent;


    Discount(double percent) {
        this.percent = percent;

    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

}
