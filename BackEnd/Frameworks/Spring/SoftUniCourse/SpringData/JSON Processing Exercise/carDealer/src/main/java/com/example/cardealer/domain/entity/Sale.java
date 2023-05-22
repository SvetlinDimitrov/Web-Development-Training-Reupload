package com.example.cardealer.domain.entity;

import com.example.cardealer.domain.CONSTANTS.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sales")
@Getter
@Setter
@AllArgsConstructor
public class Sale extends BaseEntity {
    @Column
    private Double  discount;

    @OneToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    public Sale() {
    }
}
