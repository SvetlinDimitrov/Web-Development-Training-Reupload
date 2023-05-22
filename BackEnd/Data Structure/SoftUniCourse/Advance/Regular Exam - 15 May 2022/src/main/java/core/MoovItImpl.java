package core;

import models.Route;

import java.util.*;
import java.util.stream.Collectors;

public class MoovItImpl implements MoovIt {
    public static class PairDistance{
        String startDestination;
        String endDestination;

        public PairDistance(String startDestination, String endDestination) {
            this.startDestination = startDestination;
            this.endDestination = endDestination;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PairDistance that = (PairDistance) o;
            return Objects.equals(startDestination, that.startDestination)
                    && Objects.equals(endDestination, that.endDestination);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDestination, endDestination);
        }
    }
    Map<PairDistance , Map<Double , Route>> distanceMap;
    Map<String , Route> routeMap;

    public MoovItImpl() {
        this.routeMap = new LinkedHashMap<>();
        this.distanceMap = new HashMap<>();
    }

    @Override
    public void addRoute(Route route) {
        Route route1 = routeMap.get(route.getId());
        if(route1 != null){throw new IllegalArgumentException();}

        PairDistance currentPath= new PairDistance(route.getLocationPoints().get(0) , route.getLocationPoints().get(route.getLocationPoints().size()-1));
        Map<Double, Route> doubleRouteMap = distanceMap.get(currentPath);
        if(doubleRouteMap != null){
            Route route2 = doubleRouteMap.get(route.getDistance());
            if(route2 != null){throw new IllegalArgumentException();}
        }
        distanceMap.putIfAbsent(currentPath , new HashMap<>());
        distanceMap.get(currentPath).put(route.getDistance() , route);
        routeMap.put(route.getId() , route);

    }

    @Override
    public void removeRoute(String routeId) {
        Route route = routeMap.get(routeId);
        if(route == null){throw new IllegalArgumentException();}
        routeMap.remove(routeId);
        PairDistance currentPath= new PairDistance(route.getLocationPoints().get(0) , route.getLocationPoints().get(route.getLocationPoints().size()-1));
        Map<Double, Route> doubleRouteMap = distanceMap.get(currentPath);
        doubleRouteMap.remove(route.getDistance());
        if(distanceMap.get(currentPath).isEmpty()){
            distanceMap.remove(currentPath);
        }
    }

    @Override
    public boolean contains(Route route) {
        PairDistance currentPath= new PairDistance(route.getLocationPoints().get(0) , route.getLocationPoints().get(route.getLocationPoints().size()-1));
        return distanceMap.containsKey(currentPath);
    }

    @Override
    public int size() {
        return routeMap.size();
    }

    @Override
    public Route getRoute(String routeId) {
        Route route = routeMap.get(routeId);
        if(route == null){throw new IllegalArgumentException();}
        return route;
    }

    @Override
    public void chooseRoute(String routeId) {
        Route route = getRoute(routeId);
        route.setPopularity(route.getPopularity() +1);
    }

    @Override
    public Iterable<Route> searchRoutes(String startPoint, String endPoint) {
        return routeMap.values().stream()
                .filter(e -> {
                    int indexF = e.getLocationPoints().indexOf(startPoint);
                    int indexS = e.getLocationPoints().indexOf(endPoint);
                    return indexF != -1 && indexS != -1 && indexF < indexS;
                })
                .sorted((f,s) -> {
                    int indexStartFirst = f.getLocationPoints().indexOf(startPoint);
                    int indexEndFirst = f.getLocationPoints().indexOf(endPoint);
                    int indexStartSecond = s.getLocationPoints().indexOf(startPoint);
                    int indexEndSecond = s.getLocationPoints().indexOf(endPoint);

                    if(f.getIsFavorite() && !s.getIsFavorite()){
                        return -1;
                    }
                    if(!f.getIsFavorite() && s.getIsFavorite()){
                        return 1;
                    }
                    if(indexEndFirst - indexStartFirst != indexEndSecond - indexStartSecond){
                        return (indexEndFirst - indexStartFirst) - (indexEndSecond - indexStartSecond);
                    }
                    return Integer.compare(s.getPopularity() , f.getPopularity());
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        return routeMap.values().stream()
                .filter(e->e.getLocationPoints().get(e.getLocationPoints().size()-1).equals(destinationPoint)
                        && !e.getLocationPoints().get(0).equals(destinationPoint)
                        && e.getIsFavorite())
                .sorted((f,s) -> {
                    if(Double.compare(f.getDistance() , s.getDistance()) != 0){
                        return Double.compare(f.getDistance() , s.getDistance());
                    }
                    return s.getPopularity() - f.getPopularity();
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Route> getTop5RoutesByPopularityThenByDistanceThenByCountOfLocationPoints() {
        return routeMap.values().stream()
                .sorted((f,s) -> {
                    if(Integer.compare(f.getPopularity() ,s.getPopularity()) !=0){
                        return s.getPopularity() - f.getPopularity();
                    }
                    if(Double.compare(f.getDistance() , s.getDistance()) != 0){
                        return Double.compare(f.getDistance() , s.getDistance());
                    }
                    return f.getLocationPoints().size() - s.getLocationPoints().size();
                })
                .limit(5)
                .collect(Collectors.toList());
    }
}
