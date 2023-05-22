package com.example.cardealer.domain.entity;

import com.example.cardealer.domain.CONSTANTS.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor

public class Car extends BaseEntity {
    @Column
    private String make;

    @Column
    private String model;

    @Column(name = "travelled_distance")
    private BigInteger travelledDistance;

    @ManyToMany
    private List<Part> parts;

    public Car() {
        super();
        parts = new ArrayList<>();
    }
}
