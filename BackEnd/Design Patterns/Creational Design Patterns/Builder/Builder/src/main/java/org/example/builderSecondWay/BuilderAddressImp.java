package org.example.builderSecondWay;

public class BuilderAddressImp implements BuilderAddress{
    private String town;
    private String country;
    private String zipCode;

    private Address address;

    @Override
    public BuilderAddress setTown(String town) {
        this.town = town;
        return this;
    }

    @Override
    public BuilderAddress setCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public BuilderAddress setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @Override
    public Address build() {
        address= new Address(town,country , zipCode);
        return address;
    }

    public Address getAddress() {
        return address;
    }

}
