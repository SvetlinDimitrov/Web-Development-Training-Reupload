package com.example.validationexercise.domain.entity;

import com.example.validationexercise.domain.viewMapping.ViewCompany;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(columnDefinition = "decimal(19,2)")
    private BigDecimal budget;// (must be a positive number). Cannot be null.

    @Column(columnDefinition = "text")
    private String description;// char sequence. Cannot be null. Must be at least 10 characters.

    @Column(columnDefinition = "varchar(255)")
    private String name;//. Must be unique and cannot be null. Must be between 2 and 10 characters.

    @Column(columnDefinition = "varchar(255)")
    private String town;//. Cannot be null. Must be between 2 and 10 characters.

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    public ViewCompany toViewCompany(){
        return ViewCompany.builder()
                .budget(budget)
                .description(description)
                .name(name)
                .town(town)
                .id(id)
                .build();
    }
}
