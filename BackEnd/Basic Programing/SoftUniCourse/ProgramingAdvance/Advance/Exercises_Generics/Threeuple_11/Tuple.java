package JavaAdvance.Exercises_Generics.Threeuple_11;

import java.text.DecimalFormat;

public class Tuple {
    private String firstName;
    private String lastName;
    private String address;
    private String town;
    private String name;
    private int litersOfBeer;
    private String drunkOrNot;
    private String nameAgin;

    public void setTown(String town) {
        this.town = town;
    }

    public void setDrunkOrNot(String drunkOrNot) {
        this.drunkOrNot = drunkOrNot;
    }

    public void setNameAgin(String nameAgin) {
        this.nameAgin = nameAgin;
    }

    public void setAccBalance(Double accBalance) {
        this.accBalance = accBalance;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    private Double accBalance;
    private String bankName;

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

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("####################.################################");
        return String.format("%s %s -> %s -> %s%n" + "%s -> %d -> %s%n" + "%s -> %s -> %s ",
                firstName,lastName,address,town
        ,name,litersOfBeer,drunkOrNot.equals("drunk")? "true" :"false"
        ,nameAgin,df.format(accBalance),bankName);
    }
}
