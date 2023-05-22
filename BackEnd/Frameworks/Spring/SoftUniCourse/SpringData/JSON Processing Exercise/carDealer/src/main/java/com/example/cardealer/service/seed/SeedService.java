package com.example.cardealer.service.seed;

import java.io.FileNotFoundException;

public interface SeedService {
    void seedCars() throws FileNotFoundException;
    void seedCustomers() throws FileNotFoundException;
    void seedSales();
    void seedParts() throws FileNotFoundException;
    void seedSuppliers() throws FileNotFoundException;

    default void seedAll() throws FileNotFoundException {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomers();
        seedSales();

    }
}
