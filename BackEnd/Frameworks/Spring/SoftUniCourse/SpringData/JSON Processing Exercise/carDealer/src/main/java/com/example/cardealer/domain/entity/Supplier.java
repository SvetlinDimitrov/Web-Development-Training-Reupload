package com.example.cardealer.domain.entity;

import com.example.cardealer.domain.CONSTANTS.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "suppliers")
@Getter
@Setter
@AllArgsConstructor
public class Supplier extends BaseEntity {
    @Column
    private String name;

    @Column
    private Boolean isImporter;

    public Supplier() {
    }

}
