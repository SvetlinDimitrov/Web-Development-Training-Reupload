package tripadministratorjava;

import java.util.*;
import java.util.stream.Collectors;

public class TripAdministratorImpl implements TripAdministrator {
    HashMap<String , Company> companyHashMap;
    HashMap<String,Trip> tripHashMap;
    HashMap<Company , HashSet<Trip>> site;

    public TripAdministratorImpl() {
        this.companyHashMap = new LinkedHashMap<>();
        this.tripHashMap = new LinkedHashMap<>();
        this.site = new LinkedHashMap<>();
    }

    @Override
    public void addCompany(Company c) {
        if(companyHashMap.containsKey(c.name)){
            throw new IllegalArgumentException();
        }
        companyHashMap.put(c.name , c);
        site.put(c , new LinkedHashSet<>());
    }

    @Override
    public void addTrip(Company c, Trip t) {
        if(companyHashMap.containsKey(c.name) && !tripHashMap.containsKey(t.id)){
            if(site.get(c).size() < companyHashMap.get(c.name).tripOrganizationLimit){
                site.get(c).add(t);
                tripHashMap.put(t.id , t);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean exist(Company c) {
        return companyHashMap.containsKey(c.name);
    }

    @Override
    public boolean exist(Trip t) {
        return tripHashMap.containsKey(t.id);
    }

    @Override
    public void removeCompany(Company c) {
        if(companyHashMap.containsKey(c.name)){
            for (Trip trip : site.get(c)) {
                tripHashMap.remove(trip.id);
            }
            site.remove(c);
            companyHashMap.remove(c.name);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<Company> getCompanies() {
        return companyHashMap.values();
    }

    @Override
    public Collection<Trip> getTrips() {
        return tripHashMap.values();
    }

    @Override
    public void executeTrip(Company c, Trip t) {
        if(companyHashMap.containsKey(c.name) && tripHashMap.containsKey(t.id)){
            if(site.get(c).contains(t)){
                tripHashMap.remove(t.id);
                site.get(c).remove(t);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<Company> getCompaniesWithMoreThatNTrips(int n) {
        return site.entrySet().stream()
                .filter(e->e.getValue().size() > n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Trip> getTripsWithTransportationType(Transportation t) {
        return tripHashMap.values().stream()
                .filter(e->e.transportation.equals(t))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Trip> getAllTripsInPriceRange(int lo, int hi) {
        return tripHashMap.values().stream()
                .filter(e->e.price >=lo && e.price<=hi)
                .collect(Collectors.toList());
    }
}
