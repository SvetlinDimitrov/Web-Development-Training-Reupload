package org.example.builderSecondWay;

public class Address {
    private String town;
    private String country;
    private String zipCode;

    public Address(String town, String country, String zipCode) {
        this.town = town;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getTown() {
        return town;
    }

    private void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    private void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    private void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public static BuilderAddress getBuilder(){
        return new BuilderAddressImp();
    }

    @Override
    public String toString() {
        return "Address{" +
                "town='" + town + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
