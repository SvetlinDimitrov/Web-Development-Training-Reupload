package org.example;

import org.example.constants.PowerStyle;
import org.example.constants.UnitClass;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Unit unit1 = createUnit("unit1", 23, PowerStyle.AIR, UnitClass.WARRIOR);
        Unit unit2 = createUnit("unit2", 23, PowerStyle.AIR, UnitClass.WARRIOR);
        System.out.println(unit1);
        System.out.println(unit2);
    }

    public static Unit createUnit(String name, Integer age, PowerStyle powerStyle , UnitClass unitClass){
        FlyWeigh flyWeight = FactoryFlyweight.getInstance().getFlyWeight(powerStyle, unitClass);
        Unit unit = new Unit(name , age , flyWeight);
        return unit;
    }
}