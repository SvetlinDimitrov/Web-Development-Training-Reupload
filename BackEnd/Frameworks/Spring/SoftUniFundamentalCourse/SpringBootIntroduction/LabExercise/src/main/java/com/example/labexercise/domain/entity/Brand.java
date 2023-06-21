package com.example.labexercise.domain.entity;

import com.example.labexercise.domain.constants.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    @Column(columnDefinition = "VARCHAR(255)")
    private String name;
    @Column(columnDefinition = "datetime(6)")
    private LocalDate created;
    @Column(columnDefinition = "datetime(6)")
    private LocalDate modified;
}
