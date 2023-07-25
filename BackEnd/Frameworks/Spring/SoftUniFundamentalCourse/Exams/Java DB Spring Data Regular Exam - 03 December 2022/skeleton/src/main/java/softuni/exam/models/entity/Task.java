package softuni.exam.models.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "tasks")
public class Task extends BaseEntity{
    //    • id – accepts integer values, a primary identification field, an auto incremented field.
    //    • price – accepts a very big positive number.
    //    • date – a date and time of registering the task in the "yyyy-MM-dd HH:mm:ss" format.

    @Column(columnDefinition = "decimal(19,2)" , nullable = false)
    private BigDecimal price;

    @Column(columnDefinition = "datetime(6)",nullable = false)
    private LocalDateTime date;

    @ManyToOne(cascade = CascadeType.MERGE )
    private Mechanics mechanic;

    @ManyToOne(cascade = CascadeType.MERGE )
    private Part parts;

    @ManyToOne(cascade = CascadeType.MERGE )
    private Car cars;
}
