package org.example.builderSecondWay;

public class AddressDto {
    private String town;
    private String country;
    private String zipCode;

    public AddressDto(String town, String country, String zipCode) {
        this.town = town;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
