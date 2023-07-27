package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Agent extends BaseEntity {
    //    • first name – accepts char sequences as values where their character length value higher than or equal to 2. The values are unique in the database.
    //    • last name – accepts char sequences as values where their character length value higher than or equal to 2.
    //    • email – an email – (must contains ‘@’ and ‘.’ – dot). The email of a seller is unique.
    //    • Constraint: The agents table has а relation with the towns table.

    @Column(nullable = false,
            unique = true,
            name = "first_name",
            columnDefinition = "varchar(255)")
    private String firstName;

    @Column(nullable = false,
            name = "last_name",
            columnDefinition = "varchar(255)")
    private String lastName;

    @Column(nullable = false,
            unique = true,
            name = "email",
            columnDefinition = "varchar(255)")
    private String email;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Town town;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "agent")
    private List<Offer> offers;

    public List<Offer> getOffers() {
        return offers;
    }

    public Agent setOffers(List<Offer> offers) {
        this.offers = offers;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Agent setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Agent setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Agent setEmail(String email) {
        this.email = email;
        return this;
    }

    public Town getTown() {
        return town;
    }

    public Agent setTown(Town town) {
        this.town = town;
        return this;
    }
}
