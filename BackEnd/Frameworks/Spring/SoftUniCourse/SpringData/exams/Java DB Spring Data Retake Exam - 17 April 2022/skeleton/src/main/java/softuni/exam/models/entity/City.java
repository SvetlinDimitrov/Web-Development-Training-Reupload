package softuni.exam.models.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class City extends BaseEntity {
    //    • city name – a char sequence (between 2 to 60 inclusive). The values are unique in the database. Cannot be null.
    //    • description – accepts very long char sequence (min 2 symbols).
    //    • population – accepts number values that are more than or equal to 500. Cannot be null.
    //    • Constraint: The cities table has а relation with the countries table.
    @Column(nullable = false , unique = true , columnDefinition = "varchar(255)")
    private String cityName;

    @Column( columnDefinition = "text")
    private String description;

    @Column(nullable = false , columnDefinition = "int")
    private Integer population;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Country country;

    public Country getCountry() {
        return country;
    }

    public City setCountry(Country country) {
        this.country = country;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public City setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public City setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getPopulation() {
        return population;
    }

    public City setPopulation(Integer population) {
        this.population = population;
        return this;
    }
}
