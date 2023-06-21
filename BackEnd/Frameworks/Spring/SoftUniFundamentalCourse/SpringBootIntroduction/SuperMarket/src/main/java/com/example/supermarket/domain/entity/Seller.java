package com.example.supermarket.domain.entity;

import com.example.supermarket.domain.constants.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sellers")
public class Seller  extends BaseEntity {
    @Column(name = "first_name")
    @Length(min = 2 , message = "firstName must be at least 2 characters long")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @Length(min = 2 , message = "lastName must be at least 2 characters long")
    @NotNull
    private String lastName;

    @Column
    @NotNull
    @Min(value = 18 , message = "Must be at least 18 years old")
    private Integer age;

    @Column
    @NotNull
    @Positive
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Shop shop;

    @OneToOne
    private Seller manager;

    public Seller(@NotNull String firstName, @NotNull String lastName, @NotNull Integer age, @NotNull BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }
}
