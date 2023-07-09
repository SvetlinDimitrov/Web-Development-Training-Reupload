package org.example;

import org.example.constants.PowerStyle;
import org.example.constants.UnitClass;

import java.util.ArrayList;
import java.util.HashMap;

public class FactoryFlyweight {
    private static final FactoryFlyweight INSTANCE = new FactoryFlyweight();
    private static ArrayList<FlyWeigh> list = new ArrayList<>();
    private FactoryFlyweight(){}

    public static FactoryFlyweight getInstance(){
        return INSTANCE;
    }

    public FlyWeigh getFlyWeight(PowerStyle powerStyle , UnitClass unitClass){
        FlyWeigh flyWeigh = findByCriteria(powerStyle , unitClass);
        if(flyWeigh == null){
            FlyWeigh flyWeigh1 = new FlyWeigh(powerStyle , unitClass);
            list.add(flyWeigh1);
            return flyWeigh1;
        }
        return flyWeigh;
    }

    private FlyWeigh findByCriteria(PowerStyle powerStyle , UnitClass unitClass){
        for (FlyWeigh flyWeigh : list) {
            if (flyWeigh.getPowerStyle().equals(powerStyle) && flyWeigh.getUnitClass().equals(unitClass)) {
                return flyWeigh;
            }
        }
        return null;
    }
}
