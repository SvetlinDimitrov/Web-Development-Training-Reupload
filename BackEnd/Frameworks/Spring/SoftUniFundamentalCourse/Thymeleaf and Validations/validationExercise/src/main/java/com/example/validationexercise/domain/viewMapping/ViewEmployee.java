package com.example.validationexercise.domain.viewMapping;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewEmployee {

    @NotNull
    private Date birthdate;//Cannot be null.

    @NotNull
    private String educationLevel;//Cannot be null.

    @NotNull
    @Min(value = 2)
    private String firstName;//Cannot be null. Must be at least 2 characters. Cannot be null.

    @NotNull
    private String jobTitle;//Cannot be null.

    @NotNull
    @Min(value = 2)
    private String lastName;//Cannot be null. Must be at least 2 characters. Cannot be null.

    @NotNull
    @Positive
    private BigDecimal salary;//(must be a positive number). Cannot be null.

}
