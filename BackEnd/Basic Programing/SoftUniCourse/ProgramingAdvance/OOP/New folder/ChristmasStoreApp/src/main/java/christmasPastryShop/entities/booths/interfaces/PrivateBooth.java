package christmasPastryShop.entities.booths.interfaces;

public class PrivateBooth extends BaseBooth{
    private static final double pricePerPerson = 3.50;
    public PrivateBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, pricePerPerson);
    }
}
