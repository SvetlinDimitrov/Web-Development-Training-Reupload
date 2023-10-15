package org.softuni.exam.structures;

import org.softuni.exam.entities.Airline;
import org.softuni.exam.entities.Flight;

import java.util.*;
import java.util.stream.Collectors;

public class AirlinesManagerImpl implements AirlinesManager {
    HashMap<String , Airline> airlineHashMap;
    HashMap<String , Flight> flightHashMap;
    HashMap<Airline , Set<Flight>> map;


    public AirlinesManagerImpl() {
        airlineHashMap = new LinkedHashMap<>();
        flightHashMap = new LinkedHashMap<>();
        map = new LinkedHashMap<>();

    }

    @Override
    public void addAirline(Airline airline) {
        airlineHashMap.putIfAbsent(airline.getId() , airline);
        map.putIfAbsent(airline , new LinkedHashSet<>());

    }

    @Override
    public void addFlight(Airline airline, Flight flight) {
        if(airlineHashMap.containsKey(airline.getId()) && !flightHashMap.containsKey(flight.getId())){
            flightHashMap.put(flight.getId() , flight);
            map.get(airline).add(flight);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean contains(Airline airline) {
        return airlineHashMap.containsKey(airline.getId());
    }

    @Override
    public boolean contains(Flight flight) {
        return flightHashMap.containsKey(flight.getId());
    }

    @Override
    public void deleteAirline(Airline airline) throws IllegalArgumentException {
        if(airlineHashMap.containsKey(airline.getId())){
            airlineHashMap.remove(airline.getId());
            for (Flight flight : map.get(airline)) {
                flightHashMap.remove(flight.getId());
            }
            map.remove(airline);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Flight> getAllFlights() {
        return flightHashMap.values();
    }

    @Override
    public Flight performFlight(Airline airline, Flight flight) throws IllegalArgumentException {
        if(airlineHashMap.containsKey(airline.getId())){
            if(map.get(airline).contains(flight)){
                flightHashMap.get(flight.getId()).setCompleted(true);

                return flight;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Flight> getCompletedFlights() {
        return flightHashMap.values().stream()
                .filter(Flight::isCompleted)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Flight> getFlightsOrderedByNumberThenByCompletion() {
        ArrayList<Flight>toReturn = new ArrayList<>();

        flightHashMap.values().stream()
                .filter(e->!e.isCompleted())
                .sorted(Comparator.comparing(Flight::getNumber))
                .forEach(toReturn::add);

        flightHashMap.values().stream()
                .filter(Flight::isCompleted)
                .sorted(Comparator.comparing(Flight::getNumber))
                .forEach(toReturn::add);

        return toReturn;
    }

    @Override
    public Iterable<Airline> getAirlinesOrderedByRatingThenByCountOfFlightsThenByName() {
        return map.entrySet().stream()
                .sorted((f,s)->{
                    boolean isEqual = Double.compare(f.getKey().getRating() , s.getKey().getRating()) ==0;
                    if(isEqual){
                        boolean isEqualAgain = Integer.compare(f.getValue().size() , s.getValue().size()) ==0;
                        if(isEqualAgain){
                            return f.getKey().getName().compareTo(s.getKey().getName());
                        }
                        return Integer.compare(s.getValue().size() , f.getValue().size());
                    }
                    return Double.compare(s.getKey().getRating() , f.getKey().getRating());
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Airline> getAirlinesWithFlightsFromOriginToDestination(String origin, String destination) {
//        ArrayList<Airline> airlines = new ArrayList<>();
//
//        for (Map.Entry<Airline, Set<Flight>> airlineSetEntry : map.entrySet()) {
//
//            for (Flight flight : airlineSetEntry.getValue()) {
//                boolean isNotReady = false;
//                boolean originIsFine = false;
//                boolean destinationIsFine = false;
//                if(!flight.isCompleted()){
//                    isNotReady = true;
//                }
//                if(flight.getOrigin().equals(origin)){
//                    originIsFine = true;
//                }
//                if(flight.getDestination().equals(destination)){
//                    destinationIsFine = true;
//                }
//
//                if(isNotReady && originIsFine && destinationIsFine){
//                    airlines.add(airlineSetEntry.getKey());
//                    break;
//                }
//            }
//
//        }
//        return airlines;
        return null;
    }
}
