package com.example.dtointro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Table(name = "employees")
@Entity
@Setter
@Getter
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private BigDecimal salary;

    @Column
    private LocalDate birthday;

    @Column
    private String address;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Employee> workers;

    @ManyToOne
    private Employee manager;

    public Employee() {
        birthday = LocalDate.now();
        workers = new HashSet<>();
        salary = BigDecimal.ZERO;
    }

}
