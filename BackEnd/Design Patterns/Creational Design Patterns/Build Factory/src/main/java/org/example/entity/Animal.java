package org.example.entity;

public abstract class Animal {
    private String name;
    private String hp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public abstract void showPower();
}
