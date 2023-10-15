package structures;

import entities.Deliverer;
import entities.Package;

public interface DeliveriesManager {
    void addDeliverer(Deliverer deliverer);

    void addPackage(Package _package);

    boolean contains(Deliverer deliverer);

    boolean contains(Package _package);

    Iterable<Deliverer> getDeliverers();

    Iterable<Package> getPackages();

    void assignPackage(Deliverer deliverer, Package _package) throws IllegalArgumentException;

    Iterable<Package> getUnassignedPackages();

    Iterable<Package> getPackagesOrderedByWeightThenByReceiver();

    Iterable<Deliverer> getDeliverersOrderedByCountOfPackagesThenByName();
}
