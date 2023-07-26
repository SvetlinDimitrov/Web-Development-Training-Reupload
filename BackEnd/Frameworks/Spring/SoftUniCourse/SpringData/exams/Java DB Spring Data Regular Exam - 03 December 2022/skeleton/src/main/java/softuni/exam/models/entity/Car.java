package softuni.exam.models.entity;

import lombok.*;
import softuni.exam.util.CarType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "cars")
public class Car extends BaseEntity{
    //    • id – accepts integer values, a primary identification field, an auto incremented field.
    //    • car type – the enumeration, one of the following – SUV, coupe, sport
    //    • car make – accepts char sequence (between 2 to 30 inclusive).
    //    • car model – accepts char sequence (between 2 to 30 inclusive).
    //    • year – accepts a positive number.
    //    • plate number – accepts char sequence (between 2 to 30 inclusive). The values are unique in the database.
    //    • kilometers – accepts a positive number.
    //    • engine – accepts number values that are more than or equal to 1.00.
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)" ,name = "car_type" , nullable = false)
    private CarType carType;

    @Column(columnDefinition = "varchar(255)" ,name = "car_make" , nullable = false)
    private String carMake;

    @Column(columnDefinition = "varchar(255)" ,name = "car_model" , nullable = false)
    private String carModel;

    @Column(columnDefinition = "int" ,nullable = false)
    private Integer year;

    @Column(columnDefinition = "varchar(255)" ,name = "plate_number" , nullable = false , unique = true)
    private String plateNumber;

    @Column(columnDefinition = "int" ,nullable = false)
    private Integer kilometers;

    @Column(columnDefinition = "double" , nullable = false)
    private Double engine;

    @OneToMany(mappedBy = "cars" , cascade = CascadeType.MERGE , fetch = FetchType.EAGER)
    @Column(nullable = false)
    private List<Task> task;
}
