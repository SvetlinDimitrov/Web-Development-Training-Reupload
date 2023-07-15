package com.example.cardriver.entity;

import com.example.cardriver.constants.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer extends BaseEntity {
    @Column
    private String name;

    @Column
    private LocalDate birthDate;

    @Column
    private Boolean isYoungDriver;

    @OneToMany(mappedBy = "customer")
    private List<Sale> sales;
}
