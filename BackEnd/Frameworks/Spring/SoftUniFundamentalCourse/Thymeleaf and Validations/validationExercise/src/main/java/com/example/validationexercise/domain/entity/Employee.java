package com.example.validationexercise.domain.entity;

import com.example.validationexercise.domain.viewMapping.ViewEmployee;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;// – a char sequence

    @Column(columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    @ManyToOne(fetch = FetchType.EAGER , cascade = {CascadeType.MERGE})
    private Company company;

    public ViewEmployee toViewEmployee(){
        return ViewEmployee.builder()
                .id(id)
                .birthDate(birthdate)
                .educationLevel(educationLevel)
                .firstName(firstName)
                .jobTitle(jobTitle)
                .lastName(lastName)
                .salary(salary)
                .companyName(company == null ? "" : company.getName())
                .companyId(company == null ? "" : company.getId())
                .build();
    }
}
