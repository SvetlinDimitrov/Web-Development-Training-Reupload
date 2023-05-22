package core;

import models.Doodle;

import java.util.*;
import java.util.stream.Collectors;

public class DoodleSearchImpl implements DoodleSearch {
    Map<String , Doodle > doodleMap;

    public DoodleSearchImpl() {
        this.doodleMap = new LinkedHashMap<>();
    }

    @Override
    public void addDoodle(Doodle doodle) {
        doodleMap.putIfAbsent(doodle.getId() , doodle);
    }

    @Override
    public void removeDoodle(String doodleId) {
        Doodle doodle = doodleMap.get(doodleId);
        if(doodle == null){throw new IllegalArgumentException();}
        doodleMap.remove(doodleId);
    }

    @Override
    public int size() {
        return doodleMap.size();
    }

    @Override
    public boolean contains(Doodle doodle) {
        return doodleMap.containsKey(doodle.getId());
    }

    @Override
    public Doodle getDoodle(String id) {
        Doodle doodle = doodleMap.get(id);
        if(doodle == null){throw new IllegalArgumentException();}
        return doodle;
    }

    @Override
    public double getTotalRevenueFromDoodleAds() {
        double answer = 0;
        for (Doodle value : doodleMap.values()) {
            if(value.getIsAd()){
                answer+= value.getRevenue() * value.getVisits();
            }
        }
        return answer;
    }

    @Override
    public void visitDoodle(String title) {
        Doodle doodle = doodleMap.get(title);
        if(doodle == null){throw new IllegalArgumentException();}
        doodle.setVisits(doodle.getVisits() + 1);
    }

    @Override
    public Iterable<Doodle> searchDoodles(String searchQuery) {
        return doodleMap.values().stream()
                .filter(e -> e.getTitle().contains(searchQuery))
                .sorted((f, s) -> {
                    int sizeF = f.getTitle().length();
                    int sizeS = s.getTitle().length();

                    if(f.getIsAd() && !s.getIsAd()){
                        return -1;
                     }
                    if(!f.getIsAd() && s.getIsAd()){
                        return 1;
                    }

                    if (sizeF != sizeS) {
                        return Integer.compare(sizeF, sizeS);
                    }

                    return  Integer.compare(s.getVisits(), f.getVisits());


                })
                .collect(Collectors.toList());

    }

    @Override
    public Iterable<Doodle> getDoodleAds() {
        return doodleMap.values().stream()
                .filter(Doodle::getIsAd)
                .sorted((f,s) -> {
                    if(Double.compare(f.getRevenue() , s.getRevenue()) != 0){
                        return Double.compare(s.getRevenue() , f.getRevenue());
                    }

                    return Integer.compare(s.getVisits() , f.getVisits());


                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Doodle> getTop3DoodlesByRevenueThenByVisits() {
        return doodleMap.values().stream()
                .sorted((f,s) -> {
                    if(Double.compare(f.getRevenue() , s.getRevenue()) != 0){
                        return Double.compare(s.getRevenue() , f.getRevenue());
                    }

                    return Integer.compare(s.getVisits() , f.getVisits());


                })
                .limit(3)
                .collect(Collectors.toList());
    }
}
