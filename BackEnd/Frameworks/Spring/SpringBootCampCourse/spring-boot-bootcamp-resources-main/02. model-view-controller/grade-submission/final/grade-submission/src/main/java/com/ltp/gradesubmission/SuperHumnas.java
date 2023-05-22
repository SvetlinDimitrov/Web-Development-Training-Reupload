package com.ltp.gradesubmission;

public class SuperHumnas {
    String name;
    String power;
    int level;

    public SuperHumnas(String name, String power, int level) {
        this.name = name;
        this.power = power;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
