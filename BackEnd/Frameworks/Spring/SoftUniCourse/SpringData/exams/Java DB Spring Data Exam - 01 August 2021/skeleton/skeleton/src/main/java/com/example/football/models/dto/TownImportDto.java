package com.example.football.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TownImportDto {
    //    • name – accepts char sequences as values where their character length value higher than or equal to 2. The values are unique in the database.
    //    • population – accepts number values (must be a positive number), 0 as a value is exclusive.
    //    • travel guide – a long and detailed description of all known places with a character length value higher than or equal to 10.

    @NotBlank
    @Size(min = 2)
    private String name;

    @NotNull
    @Min(1)
    @Positive
    private Integer population;

    @NotBlank
    @Size(min = 10)
    private String travelGuide;
}
