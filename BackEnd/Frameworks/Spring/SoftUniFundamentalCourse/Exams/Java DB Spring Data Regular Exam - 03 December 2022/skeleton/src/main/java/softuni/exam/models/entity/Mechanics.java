package softuni.exam.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "mechanics")
public class Mechanics extends BaseEntity{
//    • id – accepts integer values, a primary identification field, an auto incremented field.
//    • first name – accepts char sequences as values where their character length value higher than or equal to 2. The values are unique in the database.
//    • last name – accepts char sequences as values where their character length value higher than or equal to 2.
//    • email – an email – (must contains ‘@’ and ‘.’ – dot). The email of a seller is unique.
//    • phone – accepts char sequences as values where their character length value higher than or equal to 2. Can be nullable. The values are unique in the database.

    @Column(columnDefinition = "varchar(255)" ,name = "first_name" ,nullable = false , unique = true)
    private String firstName;

    @Column(columnDefinition = "varchar(255)" ,name = "last_name" , nullable = false)
    private String lastName;

    @Column(columnDefinition = "varchar(255)" , nullable = false , unique = true)
    private String email;

    @Column(columnDefinition = "varchar(255)" , nullable = true , unique = true)
    private String phone;

    @OneToMany(mappedBy = "mechanic", cascade = CascadeType.MERGE , fetch = FetchType.EAGER)
    @Column(nullable = false)
    private List<Task> task = new ArrayList<>();
}
