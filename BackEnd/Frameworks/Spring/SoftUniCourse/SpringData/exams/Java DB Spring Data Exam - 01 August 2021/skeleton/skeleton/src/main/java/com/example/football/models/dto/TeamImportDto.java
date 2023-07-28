package com.example.football.models.dto;

import com.example.football.models.entity.Town;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeamImportDto {

    //    • name – accepts char sequences as values where their character length value higher than or equal to 3. The values are unique in the database.
    //    • stadium name – accepts char sequences as values where their character length value higher than or equal to 3.
    //    • fan base – accepts number values that are more than or equal to 1000.
    //    • history – a long and detailed description of team's history with a character length value higher than or equal to 10.
    //        ◦ Note: The teams table has relation with the towns table.

    @NotBlank
    @Size(min = 3)
    private String name;

    @NotBlank
    @Size(min = 3)
    private String stadiumName;

    @NotNull
    @Min(1000)
    private Integer fanBase;

    @NotBlank
    @Size(min = 10)
    private String history;

    @NotBlank
    private String townName;
}
