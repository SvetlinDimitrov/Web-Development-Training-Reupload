package barbershopjava;

public class Barber {

    public String name;
    public int haircutPrice;
    public int stars;

    public Barber(String name, int haircutPrice, int stars) {
        this.name = name;
        this.haircutPrice = haircutPrice;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public int getHaircutPrice() {
        return haircutPrice;
    }

    public int getStars() {
        return stars;
    }
}
