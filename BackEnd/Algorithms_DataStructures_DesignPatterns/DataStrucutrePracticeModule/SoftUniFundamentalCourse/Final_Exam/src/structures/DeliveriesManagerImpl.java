package structures;

import entities.Deliverer;
import entities.Package;

import java.util.*;
import java.util.stream.Collectors;

public class DeliveriesManagerImpl implements DeliveriesManager {
    HashMap<String, Deliverer> delivererHashMap;
    HashMap<String, Package> packageHashMap;
    HashMap<String, Package> unsentPackageHashMap;
    HashMap<Deliverer, ArrayList<Package>> map;

    public DeliveriesManagerImpl() {
        delivererHashMap = new LinkedHashMap<>();
        packageHashMap = new LinkedHashMap<>();
        map = new LinkedHashMap<>();
        unsentPackageHashMap = new LinkedHashMap<>();
    }

    @Override
    public void addDeliverer(Deliverer deliverer) {
        delivererHashMap.putIfAbsent(deliverer.getId(), deliverer);
        map.putIfAbsent(deliverer, new ArrayList<>());
    }

    @Override
    public void addPackage(Package _package) {
        packageHashMap.putIfAbsent(_package.getId(), _package);
        unsentPackageHashMap.putIfAbsent(_package.getId(), _package);
    }

    @Override
    public boolean contains(Deliverer deliverer) {
        return delivererHashMap.containsKey(deliverer.getId());
    }

    @Override
    public boolean contains(Package _package) {
        return packageHashMap.containsKey(_package.getId());
    }

    @Override
    public Iterable<Deliverer> getDeliverers() {
        return delivererHashMap.values();
    }

    @Override
    public Iterable<Package> getPackages() {
        return packageHashMap.values();
    }

    @Override
    public void assignPackage(Deliverer deliverer, Package _package) throws IllegalArgumentException {
        if (delivererHashMap.containsKey(deliverer.getId()) && packageHashMap.containsKey(_package.getId())) {
            map.get(deliverer).add(_package);
            unsentPackageHashMap.remove(_package.getId());
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Package> getUnassignedPackages() {
        return unsentPackageHashMap.values();
    }

    @Override
    public Iterable<Package> getPackagesOrderedByWeightThenByReceiver() {
        return packageHashMap.values().stream()
                .sorted(Comparator.comparing(Package::getWeight).reversed().thenComparing(Package::getReceiver))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Deliverer> getDeliverersOrderedByCountOfPackagesThenByName() {
        return null;
    }
}
