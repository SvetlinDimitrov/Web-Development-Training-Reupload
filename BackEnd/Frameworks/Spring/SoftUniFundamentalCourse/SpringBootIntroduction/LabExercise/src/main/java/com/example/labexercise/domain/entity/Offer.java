package com.example.labexercise.domain.entity;

import com.example.labexercise.domain.constants.BaseEntity;
import com.example.labexercise.domain.constants.Engine;
import com.example.labexercise.domain.constants.Transmission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {
    @Column(columnDefinition = "text")
    private String description;

    @Column(columnDefinition = "int(11)")
    @Enumerated
    private Engine engine;

    @Column(name = "image_url" , columnDefinition = "varchar(255)")
    private String imageUrl;

    @Column(columnDefinition = "int(11)")
    private Integer mileage;

    @Column(columnDefinition = "decimal(19,2)")
    private BigDecimal price;

    @Column(columnDefinition = "int(11)")
    @Enumerated
    private Transmission transmission;

    @Column(columnDefinition = "int(11)")
    private Integer year;

    @Column(columnDefinition = "datetime(6)")
    private LocalDate created;

    @Column(columnDefinition = "datetime(6)")
    private LocalDate modified;

    @OneToOne
    private Model model;

    @OneToOne
    private User seller;
}
