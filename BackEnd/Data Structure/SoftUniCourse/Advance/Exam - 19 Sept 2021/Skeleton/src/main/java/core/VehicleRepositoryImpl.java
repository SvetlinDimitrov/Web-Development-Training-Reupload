package core;

import models.Vehicle;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VehicleRepositoryImpl implements VehicleRepository {
    Map<String , Vehicle> vehicleMap;
    Map<String , String> carSellerPair;
    Map<String , Set<Vehicle>> sellerMap;


    public VehicleRepositoryImpl() {
        this.vehicleMap = new LinkedHashMap<>();
        this.sellerMap = new LinkedHashMap<>();
        this.carSellerPair = new HashMap<>();

    }

    @Override
    public void addVehicleForSale(Vehicle vehicle, String sellerName) {
        vehicleMap.putIfAbsent(vehicle.getId(), vehicle);
        carSellerPair.putIfAbsent(vehicle.getId(), sellerName);
        sellerMap.putIfAbsent(sellerName , new LinkedHashSet<>());
        sellerMap.get(sellerName).add(vehicle);
    }

    @Override
    public void removeVehicle(String vehicleId) {
        Vehicle vehicle = vehicleMap.get(vehicleId);
        if(vehicle == null){throw new IllegalArgumentException();}
        vehicleMap.remove(vehicleId);
        String seller = carSellerPair.get(vehicleId);
        carSellerPair.remove(vehicleId);
        sellerMap.get(seller).remove(vehicle);
    }

    @Override
    public int size() {
        return vehicleMap.size();
    }

    @Override
    public boolean contains(Vehicle vehicle) {
        return vehicleMap.containsKey(vehicle.getId());
    }

    @Override
    public Iterable<Vehicle> getVehicles(List<String> keywords) {
        return vehicleMap.values().stream()
                .filter(e-> keywords.contains(e.getBrand()) || keywords.contains(e.getModel()) || keywords.contains(e.getLocation()) || keywords.contains(e.getColor()))
                .sorted((f,s) -> {
                    if(f.getIsVIP() && !s.getIsVIP()){
                        return -1;
                    }
                    if(!f.getIsVIP() && s.getIsVIP()){
                        return 1;
                    }
                    return Double.compare(f.getPrice() , s.getPrice());
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Vehicle> getVehiclesBySeller(String sellerName) {
        Set<Vehicle> vehicles = sellerMap.get(sellerName);
        if(vehicles == null){throw new IllegalArgumentException();}
        return vehicles;
    }

    @Override
    public Iterable<Vehicle> getVehiclesInPriceRange(double lowerBound, double upperBound) {
        return vehicleMap.values().stream()
                .filter(e-> Double.compare(e.getPrice() , lowerBound) >= 0 && Double.compare(upperBound , e.getPrice()) >=0)
                .sorted(Comparator.comparing(Vehicle::getHorsepower).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Vehicle>> getAllVehiclesGroupedByBrand() {
        if(vehicleMap.isEmpty()){throw new IllegalArgumentException();}
        Map<String , Set<Vehicle>> answer = new LinkedHashMap<>();
        for (Vehicle value : vehicleMap.values()) {
            answer.putIfAbsent(value.getBrand() , new TreeSet<>(Comparator.comparingDouble(Vehicle::getPrice)));
            answer.get(value.getBrand()).add(value);
        }
        Map<String , List<Vehicle>> toReturn = new LinkedHashMap<>();
        for (Map.Entry<String, Set<Vehicle>> stringSetEntry : answer.entrySet()) {
            toReturn.put(stringSetEntry.getKey() , new ArrayList<>(stringSetEntry.getValue()));
        }
        return toReturn;
    }

    @Override
    public Iterable<Vehicle> getAllVehiclesOrderedByHorsepowerDescendingThenByPriceThenBySellerName() {
        return vehicleMap.values().stream()
                .sorted((f,s) -> {
                    if(f.getHorsepower() != s.getHorsepower()){
                        return s.getHorsepower() - f.getHorsepower();
                    }
                    if(Double.compare(f.getPrice() , s.getPrice()) != 0){
                        return Double.compare(f.getPrice() , s.getPrice());
                    }
                    return carSellerPair.get(f.getId()).compareTo(carSellerPair.get(s.getId()));
                })
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle buyCheapestFromSeller(String sellerName) {
        Set<Vehicle> vehicles = sellerMap.get(sellerName);
        if(vehicles == null || vehicles.isEmpty()){throw new IllegalArgumentException();}

        String carId = "";
        double minValue = Double.MAX_VALUE;

        for (Vehicle vehicle : sellerMap.get(sellerName)) {
            if(Double.compare(minValue , vehicle.getPrice()) < 0){
                minValue = vehicle.getPrice();
                carId = vehicle.getId();
            }
        }

        carSellerPair.remove(carId);
        Vehicle vehicle = vehicleMap.get(carId);
        vehicleMap.remove(carId);
        sellerMap.get(sellerName).remove(vehicle);
        return vehicle;
    }
}
