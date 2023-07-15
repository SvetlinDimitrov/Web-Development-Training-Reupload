package com.example.cardriver.entity;


import com.example.cardriver.constants.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car extends BaseEntity {

    @Column
    private String model;

    @Column
    private String make;

    @Column
    private BigInteger travelledDistance;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "parts_cars",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "part_id"))
    private List<Part> parts = new ArrayList<>();

    @OneToMany(mappedBy = "car" , cascade = CascadeType.MERGE)
    private List<Sale> sales = new ArrayList<>();
}



