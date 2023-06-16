package com.example.validationexercise.domain.viewMapping;

import com.example.validationexercise.domain.entity.Employee;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewEmployee {



    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;//Cannot be null.

    @NotNull
    private String educationLevel;//Cannot be null.

    @NotNull
    @Size(min = 2)
    private String firstName;//Cannot be null. Must be at least 2 characters. Cannot be null.

    @NotNull
    private String jobTitle;//Cannot be null.

    @NotNull
    @Size(min = 2)
    private String lastName;//Cannot be null. Must be at least 2 characters. Cannot be null.

    @NotNull
    @Positive
    private BigDecimal salary;//(must be a positive number). Cannot be null.

    //TODO: custom annotation that checks if the current name of the company is present
    private String companyId;

    private String companyName;

    public Employee toEmployee(){
        return Employee.builder()
                .birthdate(birthDate)
                .educationLevel(educationLevel)
                .firstName(firstName)
                .jobTitle(jobTitle)
                .lastName(lastName)
                .salary(salary)
                .build();
    }

}
