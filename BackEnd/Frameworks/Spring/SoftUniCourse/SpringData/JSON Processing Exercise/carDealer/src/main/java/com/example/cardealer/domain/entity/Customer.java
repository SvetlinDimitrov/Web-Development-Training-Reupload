package com.example.cardealer.domain.entity;

import com.example.cardealer.domain.CONSTANTS.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {
    @Column
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column
    private Boolean isYoungDriver;

}
