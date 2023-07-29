package softuni.exam.models.dto;

import softuni.exam.util.enums.StarType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class StarImportDto {

    //    • name - accepts char sequence (between 2 to 30 inclusive). The values are unique in the database.
//    • light years - The distance from Earth in light years. Accepts only positive number.
//    • description - a long and detailed description about the star with a character length value higher than or equal to 6.
//    • star type - categorization of the stars. Ordinal enumeration, one of the following – RED_GIANT, WHITE_DWARF, NEUTRON_STAR
//    • observers – a collection with all the astronomers that are studying the star.

    @NotBlank
    @Size(min = 2 , max = 30)
    private String name;

    @NotNull
    @Positive
    private Double lightYears;

    @NotBlank
    @Size(min = 6)
    private String description;

    @NotNull
    private StarType starType;

    @NotNull
    private Long constellation;

    public String getName() {
        return name;
    }

    public StarImportDto setName(String name) {
        this.name = name;
        return this;
    }

    public Double getLightYears() {
        return lightYears;
    }


    public StarImportDto setLightYears(Double lightYears) {
        this.lightYears = lightYears;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StarImportDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public StarType getStar() {
        return starType;
    }

    public StarImportDto setStar(StarType starType) {
        this.starType = starType;
        return this;
    }

    public Long getConstellation() {
        return constellation;
    }

    public StarImportDto setConstellation(Long constellation) {
        this.constellation = constellation;
        return this;
    }
}
