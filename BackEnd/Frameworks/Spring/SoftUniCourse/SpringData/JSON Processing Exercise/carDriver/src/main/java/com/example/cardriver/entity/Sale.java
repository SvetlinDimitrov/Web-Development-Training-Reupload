package com.example.cardriver.entity;


import com.example.cardriver.constants.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sales")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sale  extends BaseEntity {
    @Column
    private Double discount;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Car car;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Customer customer;
}
