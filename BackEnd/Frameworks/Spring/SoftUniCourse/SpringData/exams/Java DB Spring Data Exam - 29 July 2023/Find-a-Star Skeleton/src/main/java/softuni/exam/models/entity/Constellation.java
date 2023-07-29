package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "constellations")
public class Constellation extends BaseEntity {
    //    • name – accepts char sequence (between 3 to 20 inclusive). The values are unique in the database.
    //    • description - accepts char sequence about the naming of the constellation with a character length value higher than or equal to 5.
    //    • stars – a collection of all stars that are part the constellation
    //    • Constraint: The constellations table has a relation with the stars table.


    @Column(nullable = false ,
            unique = true ,
            columnDefinition = "varchar(255)")
    private String name;

    @Column(nullable = false ,
            columnDefinition = "varchar(255)")
    private String description;

    @OneToMany(mappedBy = "constellation")
    private List<Star> stars = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Constellation setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Constellation setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Star> getStars() {
        return stars;
    }

    public Constellation setStars(List<Star> stars) {
        this.stars = stars;
        return this;
    }
}
