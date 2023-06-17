package com.example.validationexercise.domain.viewMapping;

import com.example.validationexercise.domain.entity.Company;
import com.example.validationexercise.exeptions.companyNameValidation.CompanyNameConstant;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViewCompany {

    private String id;

    @Positive
    @NotNull
    private BigDecimal budget;

    @NotNull
    @Size(min = 10)
    private String description;

    @CompanyNameConstant
    @NotNull
    @Size(min = 2, max = 10)
    private String name;

    @NotNull
    @Size(min = 2, max = 10)
    private String town;

    public Company toCompany(){
        return Company.builder()
                .budget(budget)
                .description(description)
                .name(name)
                .town(town)
                .build();
    }
}
