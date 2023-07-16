package com.example.cardriver.entity;

import com.example.cardriver.constants.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Part extends BaseEntity {

    @Column
    private String name ;

    @Column
    private BigDecimal price;

    @Column
    private Integer quantity;


    @ManyToMany(mappedBy = "parts")
    private List<Car> cars = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    private Supplier supplier;
}
