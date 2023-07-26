package softuni.exam.models.dto.inport;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CityJsonDto {
    //    • city name – a char sequence (between 2 to 60 inclusive). The values are unique in the database. Cannot be null.
    //    • description – accepts very long char sequence (min 2 symbols).
    //    • population – accepts number values that are more than or equal to 500. Cannot be null.
    //    • Constraint: The cities table has а relation with the countries table.

    @Size(min = 2 , max = 60)
    @NotBlank
    private String cityName;

    @Size(min = 2)
    private String description;

    @Min(500)
    @NotNull
    private Integer population;

    @NotNull
    private Long country;

    public String getCityName() {
        return cityName;
    }

    public CityJsonDto setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CityJsonDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getPopulation() {
        return population;
    }

    public CityJsonDto setPopulation(Integer population) {
        this.population = population;
        return this;
    }

    public Long getCountry() {
        return country;
    }

    public CityJsonDto setCountry(Long country) {
        this.country = country;
        return this;
    }
}
