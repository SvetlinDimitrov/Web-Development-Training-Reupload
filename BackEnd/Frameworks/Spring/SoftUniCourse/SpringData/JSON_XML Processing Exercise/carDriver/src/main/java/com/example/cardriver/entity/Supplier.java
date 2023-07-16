package com.example.cardriver.entity;

import com.example.cardriver.constants.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "suppliers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier extends BaseEntity {
    @Column
    private String name;

    @Column
    private Boolean isImporter;

    @OneToMany(mappedBy = "supplier")
    private List<Part> part;
}
