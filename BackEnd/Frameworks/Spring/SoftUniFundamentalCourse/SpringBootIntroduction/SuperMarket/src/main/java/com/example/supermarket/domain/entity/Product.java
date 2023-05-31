package com.example.supermarket.domain.entity;

import com.example.supermarket.domain.constants.BaseEntity;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product  extends BaseEntity {
    @Column(name = "best_before")
    private LocalDate bestBefore;

    @Column
    private String description;

    @Column(name = "name")
    @Length(min = 2 , message = "Name must be at least 2 characters long")
    @NotNull
    private String name;

    @Column
    @Positive
    @NotNull
    private BigDecimal price;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Shop shop;

}
