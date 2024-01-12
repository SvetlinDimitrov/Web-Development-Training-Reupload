package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        setKilograms(7);
    }

    @Override
    public void eating() {
        int currentKilograms = getKilograms();
        setKilograms(currentKilograms + 1);
    }
}
