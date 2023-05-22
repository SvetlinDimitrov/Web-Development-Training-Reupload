package com.example.cardealer.domain.entity;

import com.example.cardealer.domain.CONSTANTS.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "parts")
@Getter
@Setter
@AllArgsConstructor
public class Part extends BaseEntity {

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private Double quantity;

    @ManyToOne
    private Supplier suppliers;

    public Part() {
    }
}
