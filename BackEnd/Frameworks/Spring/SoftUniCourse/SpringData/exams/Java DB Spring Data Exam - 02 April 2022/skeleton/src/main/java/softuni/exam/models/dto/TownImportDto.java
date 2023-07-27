package softuni.exam.models.dto;

import javax.validation.constraints.*;

public class TownImportDto {
    //    • town name – accepts char sequences as values where their character length value is higher than or equal to 2. The values are unique in the database.
    //    • population – accepts number values (must be positive), 0 as a value is exclusive.

    @NotBlank
    @Size(min = 2)
    private String townName;
    @NotNull
    @Positive
    @Min(1)
    private Integer population;

    public String getTownName() {
        return townName;
    }

    public TownImportDto setTownName(String townName) {
        this.townName = townName;
        return this;
    }

    public Integer getPopulation() {
        return population;
    }

    public TownImportDto setPopulation(Integer population) {
        this.population = population;
        return this;
    }
}
