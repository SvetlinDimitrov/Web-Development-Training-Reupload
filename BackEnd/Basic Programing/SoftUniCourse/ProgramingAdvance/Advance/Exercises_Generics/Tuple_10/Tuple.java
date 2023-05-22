package JavaAdvance.Exercises_Generics.Tuple_10;

import java.text.DecimalFormat;

public class Tuple {
    private String firstName;
    private String lastName;
    private String address;
    private String name;
    private int litersOfBeer;
    private int integer;
    private Double doublee;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLitersOfBeer(int litersOfBeer) {
        this.litersOfBeer = litersOfBeer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public void setDoublee(double doublee) {
        this.doublee = doublee;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat(".################################");
        return String.format("%s %s -> %s%n" + "%s -> %d%n" + "%d -> %s",firstName,lastName , address
        ,name , litersOfBeer , integer , df.format(doublee));
    }
}
