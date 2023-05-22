package core;

import models.Vehicle;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class VehicleRepositoryTests {
    private VehicleRepository vehicleRepository;

    @Before
    public void setup() {
        this.vehicleRepository = new VehicleRepositoryImpl();
    }

    @Test
    public void testAddVehicle_WithCorrectData_ShouldCorrectlyAddVehicle() {
        Vehicle vehicle = new Vehicle(1 + "", "BMW", "X5", "Sofia", "Blue", 400, 50000, true);

        this.vehicleRepository.addVehicleForSale(vehicle, "George");

        assertTrue(this.vehicleRepository.contains(vehicle));
    }

    @Test
    public void testContains_WithNonexistentVehicle_ShouldReturnFalse() {
        Vehicle vehicle = new Vehicle(1 + "", "BMW", "X5", "Sofia", "Blue", 400, 50000, true);
        Vehicle vehicle2 = new Vehicle(2 + "", "BMW2", "X52", "Sofia2", "Blue2", 500, 60000, false);

        this.vehicleRepository.addVehicleForSale(vehicle, "George");

        assertFalse(this.vehicleRepository.contains(vehicle2));
    }

    @Test
    public void testRemoveVehicle_WithNonexistentVehicle_ShouldThrowException() {
        Vehicle vehicle = new Vehicle(1 + "", "BMW", "X5", "Sofia", "Blue", 400, 50000, true);
        Vehicle vehicle2 = new Vehicle(2 + "", "BMW", "X52", "Sofia2", "Blue2", 500, 60000, false);
        Vehicle vehicle3 = new Vehicle(3 + "", "Audi", "A3", "Sofia3", "Blue3", 300, 70000, false);

        this.vehicleRepository.addVehicleForSale(vehicle3, "George");
        this.vehicleRepository.addVehicleForSale(vehicle2, "George");
        this.vehicleRepository.addVehicleForSale(vehicle, "George");

        assertThrows(IllegalArgumentException.class, () -> this.vehicleRepository.removeVehicle("non-existent"));
    }

    @Test
    public void testGetVehiclesOrdered_WithExistentVehicles_ShouldCorrectlyOrderedVehicles() {
        Vehicle vehicle = new Vehicle(1 + "", "BMW", "X5", "Sofia", "Blue", 400, 50000, true);
        Vehicle vehicle2 = new Vehicle(2 + "", "BMW", "X52", "Sofia2", "Blue2", 500, 61000, false);
        Vehicle vehicle3 = new Vehicle(3 + "", "Audi", "A3", "Sofia3", "Blue3", 300, 70000, false);
        Vehicle vehicle4 = new Vehicle(4 + "", "Audi", "A3", "Sofia3", "Blue3", 500, 88000, false);
        Vehicle vehicle5 = new Vehicle(5 + "", "Audi", "A3", "Sofia3", "Blue3", 500, 61000, false);

        this.vehicleRepository.addVehicleForSale(vehicle, "George");
        this.vehicleRepository.addVehicleForSale(vehicle2, "Jack");
        this.vehicleRepository.addVehicleForSale(vehicle3, "Phill");
        this.vehicleRepository.addVehicleForSale(vehicle4, "Isacc");
        this.vehicleRepository.addVehicleForSale(vehicle5, "Igor");

        List<Vehicle> orderedVehicles = StreamSupport.stream(this.vehicleRepository.getAllVehiclesOrderedByHorsepowerDescendingThenByPriceThenBySellerName().spliterator(), false)
                .collect(Collectors.toList());

        assertEquals(5, orderedVehicles.size());

        assertEquals(vehicle5, orderedVehicles.get(0));
        assertEquals(vehicle2, orderedVehicles.get(1));
        assertEquals(vehicle4, orderedVehicles.get(2));
        assertEquals(vehicle, orderedVehicles.get(3));
        assertEquals(vehicle3, orderedVehicles.get(4));
    }

    @Test
    public void testBuyCheapest_With1000000Vehicles_ShouldPassQuickly() {
        int count = 1000000;

        for (int i = count, j = 0; i >= 0 && j <= count; i--, j++) {
            String sellerName = "George";

            Vehicle vehicle = new Vehicle(i + "", "BMW", "X5", "Sofia", "Blue", i * 10, i, true);

            this.vehicleRepository.addVehicleForSale(vehicle, sellerName);
        }

        long start = System.currentTimeMillis();

        this.vehicleRepository.buyCheapestFromSeller("George");

        long stop = System.currentTimeMillis();

        long elapsedTime = stop - start;

        assertTrue(elapsedTime <= 50);
    }
}
