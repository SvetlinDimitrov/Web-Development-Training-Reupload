package com.example.validationexercise.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;// – a char sequence

    @Column(columnDefinition = "date")
    private Date birthdate;//Cannot be null.

    @Column(columnDefinition = "varchar(255)")
    private String educationLevel;//Cannot be null.

    @Column(columnDefinition = "varchar(255)")
    private String firstName;//Cannot be null. Must be at least 2 characters. Cannot be null.

    @Column(columnDefinition = "varchar(255)")
    private String jobTitle;//Cannot be null.

    @Column(columnDefinition = "varchar(255)")
    private String lastName;//Cannot be null. Must be at least 2 characters. Cannot be null.

    @Column(columnDefinition = "decimal(19,2)")
    private BigDecimal salary;// – a number (must be a positive number). Cannot be null.

    @ManyToOne
    private Company company;
}
