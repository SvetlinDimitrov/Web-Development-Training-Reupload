package com.example.democache;

public class Animal {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Animal setId(Integer id) {
        this.id = id;
        return this;
    }

    public Animal(Integer id) {
        this.id = id;
    }
}
