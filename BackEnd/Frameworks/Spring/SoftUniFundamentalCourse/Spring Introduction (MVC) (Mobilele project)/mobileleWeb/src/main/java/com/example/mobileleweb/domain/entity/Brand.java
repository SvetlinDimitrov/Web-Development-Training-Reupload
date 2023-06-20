package com.example.mobileleweb.domain.entity;

import com.example.mobileleweb.domain.constants.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "brands")
public class Brand extends BaseEntity {
    @Column(columnDefinition = "VARCHAR(255)")
    private String name;
    @Column(columnDefinition = "datetime(6)")
    private LocalDate created;
    @Column(columnDefinition = "datetime(6)")
    private LocalDate modified;
}
