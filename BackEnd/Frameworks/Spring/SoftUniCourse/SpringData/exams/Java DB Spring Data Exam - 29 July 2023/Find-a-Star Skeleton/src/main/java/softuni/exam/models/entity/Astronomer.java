package softuni.exam.models.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "astronomers")
public class Astronomer extends BaseEntity {
    //    • first name - accepts char sequence (between 2 to 30 inclusive).
    //    • last name - accepts char sequence (between 2 to 30 inclusive).
    //    • salary - accepts number values that are more than or equal to 15000.00.
    //    • averageObservationHours - accepts number values that are more than 500.00.
    //    • birthday - a date in the "yyyy-MM-dd" format. Can be nullable.
    //    • observing star - the current star that the astronomer is studying.

    @Column(nullable = false,
            columnDefinition = "varchar(255)",
            name = "first_name")
    private String firstName;

    @Column(nullable = false,
            columnDefinition = "varchar(255)",
            name = "last_name")
    private String lastName;

    @Column(nullable = false,
            columnDefinition = "double")
    private Double salary;

    @Column(nullable = false,
            columnDefinition = "double",
            name = "average_observation_hours")
    private Double averageObservationHours;

    @Column(columnDefinition = "date")
    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "observing_star_id")
    private Star observingStar;

    public String getFirstName() {
        return firstName;
    }

    public Astronomer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Astronomer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Double getSalary() {
        return salary;
    }

    public Astronomer setSalary(Double salary) {
        this.salary = salary;
        return this;
    }

    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public Astronomer setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Astronomer setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public Star getObservingStar() {
        return observingStar;
    }

    public Astronomer setObservingStar(Star observingStar) {
        this.observingStar = observingStar;
        return this;
    }
}
