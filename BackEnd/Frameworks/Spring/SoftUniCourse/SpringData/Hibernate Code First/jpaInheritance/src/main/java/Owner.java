import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @OneToMany(targetEntity = Pet.class )
    @JoinColumn(name = "pet_id",
    referencedColumnName = "id")
    private Set<Pet> pets;

    public Owner(String name) {
        this();
        this.name = name;
    }

    public Owner() {
        pets = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
