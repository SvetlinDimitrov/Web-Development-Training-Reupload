package com;

import java.util.HashMap;
import java.util.Map;

public class HelloRepo {
    private final Map<String , HelloEntity> helloEntityMap = new HashMap<>();

    public HelloRepo() {

        HelloEntity entity = new HelloEntity("United States", "Hello!");
        HelloEntity entity2 = new HelloEntity("France", "Bonjour!");
        HelloEntity entity3 = new HelloEntity("Spain", "iHola!");
        HelloEntity entity4 = new HelloEntity("Japanese", "こんにちは");
        HelloEntity entity5 = new HelloEntity("Bulgaria", "Здравейте!");

        helloEntityMap.put(entity.getCountry() , entity);
        helloEntityMap.put(entity2.getCountry() , entity2);
        helloEntityMap.put(entity3.getCountry() , entity3);
        helloEntityMap.put(entity4.getCountry() , entity4);
        helloEntityMap.put(entity5.getCountry() , entity5);
    }

    public Map<String, HelloEntity> getHelloEntityMap() {
        return helloEntityMap;
    }
}
