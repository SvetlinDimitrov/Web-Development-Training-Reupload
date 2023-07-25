package softuni.exam.models.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "parts")
public class Part extends BaseEntity{
//    • id – accepts integer values, a primary identification field, an auto incremented field.
//    • part name – accepts char sequence (between 2 to 19 inclusive). The values are unique in the database.
//    • price – a floating point number. Must be between 10 and 2000 (both numbers are INCLUSIVE).
//    • quantity – accepts a positive number.
    @Column(columnDefinition = "varchar(255)" ,name = "part_name" , nullable = false , unique = true)
    private String partName;

    @Column(columnDefinition = "double" , nullable = false)
    private Double price;

    @Column(columnDefinition = "int",nullable = false)
    private Integer quantity;

    @OneToMany(mappedBy = "parts" , cascade = CascadeType.MERGE , fetch = FetchType.EAGER)
    @Column(nullable = false)
    private List<Task> task = new ArrayList<>();
}
