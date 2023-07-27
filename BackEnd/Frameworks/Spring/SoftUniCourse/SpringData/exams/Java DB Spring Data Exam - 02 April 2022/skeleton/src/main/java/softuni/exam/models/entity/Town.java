package softuni.exam.models.entity;

import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Town extends BaseEntity {
    //    • town name – accepts char sequences as values where their character length value is higher than or equal to 2. The values are unique in the database.
    //    • population – accepts number values (must be positive), 0 as a value is exclusive.

    @Column(unique = true,
            nullable = false,
            columnDefinition = "varchar(255)",
            name = "town_name")
    private String townName;
    @Column(nullable = false,
            columnDefinition = "int")
    private Integer population;

    @OneToMany(mappedBy = "town" , cascade = CascadeType.MERGE)
    private List<Apartment> apartments;

    @OneToMany(mappedBy = "town")
    private List<Agent> agents;

    public List<Apartment> getApartments() {
        return apartments;
    }

    public Town setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
        return this;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public Town setAgents(List<Agent> agents) {
        this.agents = agents;
        return this;
    }

    public String getTownName() {
        return townName;
    }

    public Town setTownName(String townName) {
        this.townName = townName;
        return this;
    }

    public Integer getPopulation() {
        return population;
    }

    public Town setPopulation(Integer population) {
        this.population = population;
        return this;
    }
}
