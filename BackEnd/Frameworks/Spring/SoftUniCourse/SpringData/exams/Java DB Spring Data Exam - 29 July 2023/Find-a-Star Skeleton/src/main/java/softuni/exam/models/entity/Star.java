package softuni.exam.models.entity;

import softuni.exam.util.enums.StarType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stars")
public class Star extends BaseEntity {

//    • name - accepts char sequence (between 2 to 30 inclusive). The values are unique in the database.
//    • light years - The distance from Earth in light years. Accepts only positive number.
//    • description - a long and detailed description about the star with a character length value higher than or equal to 6.
//    • star type - categorization of the stars. Ordinal enumeration, one of the following – RED_GIANT, WHITE_DWARF, NEUTRON_STAR
//    • observers – a collection with all the astronomers that are studying the star.


    @Column(nullable = false,
            unique = true,
            columnDefinition = "varchar(255)")
    private String name;

    @Column(nullable = false,
            columnDefinition = "double",
            name = "light_years")
    private Double lightYears;

    @Column(nullable = false,
            columnDefinition = "text")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,
            columnDefinition = "varchar(255)",
            name = "star_type")
    private StarType star;

    @ManyToOne
    @JoinColumn(name = "constellation_id")
    private Constellation constellation;

    @OneToMany(mappedBy = "observingStar")
    private List<Astronomer> observers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Star setName(String name) {
        this.name = name;
        return this;
    }

    public Double getLightYears() {
        return lightYears;
    }

    public Star setLightYears(Double lightYears) {
        this.lightYears = lightYears;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Star setDescription(String description) {
        this.description = description;
        return this;
    }

    public StarType getStar() {
        return star;
    }

    public Star setStar(StarType star) {
        this.star = star;
        return this;
    }

    public Constellation getConstellation() {
        return constellation;
    }

    public Star setConstellation(Constellation constellation) {
        this.constellation = constellation;
        return this;
    }

    public List<Astronomer> getObservers() {
        return observers;
    }

    public Star setObservers(List<Astronomer> observers) {
        this.observers = observers;
        return this;
    }
}
