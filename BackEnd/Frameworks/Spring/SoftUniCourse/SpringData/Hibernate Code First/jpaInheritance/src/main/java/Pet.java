import jakarta.persistence.*;

@Entity
class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)

    private String name;

    public String getName() {
        return name;
    }

    public Pet(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
