package org.example.builderSecondWay;

public interface BuilderAddress {
    BuilderAddress setTown(String name);

    BuilderAddress setCountry(String name);

    BuilderAddress setZipCode(String name);

    Address build();
}
