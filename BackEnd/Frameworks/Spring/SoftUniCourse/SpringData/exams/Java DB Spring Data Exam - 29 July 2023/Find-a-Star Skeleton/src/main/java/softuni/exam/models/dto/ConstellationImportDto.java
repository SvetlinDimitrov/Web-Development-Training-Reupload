package softuni.exam.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ConstellationImportDto {

    //    • name – accepts char sequence (between 3 to 20 inclusive). The values are unique in the database.
    //    • description - accepts char sequence about the naming of the constellation with a character length value higher than or equal to 5.
    //    • stars – a collection of all stars that are part the constellation
    //    • Constraint: The constellations table has a relation with the stars table.
    @NotBlank
    @Size(min = 3 , max = 20)
    private String name;

    @NotBlank
    @Size(min = 5)
    private String description;


    public String getName() {
        return name;
    }

    public ConstellationImportDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ConstellationImportDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
