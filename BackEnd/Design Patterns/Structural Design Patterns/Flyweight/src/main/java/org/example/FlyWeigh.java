package org.example;

import org.example.constants.PowerStyle;
import org.example.constants.UnitClass;

public class FlyWeigh {
    private PowerStyle powerStyle;
    private UnitClass unitClass;

    public FlyWeigh(PowerStyle powerStyle, UnitClass unitClass) {
        this.powerStyle = powerStyle;
        this.unitClass = unitClass;
    }

    public PowerStyle getPowerStyle() {
        return powerStyle;
    }

    public UnitClass getUnitClass() {
        return unitClass;
    }
}
