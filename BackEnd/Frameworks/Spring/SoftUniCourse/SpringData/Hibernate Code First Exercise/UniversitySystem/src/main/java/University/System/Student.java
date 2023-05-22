package University.System;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student extends Person {

    @Column(name = "average_grade")
    private Double averageGrade;

    @Column
    private Boolean attendance;

    @ManyToMany
    @JoinTable(
            name = "courses_students",
            joinColumns = @JoinColumn(name = "courses" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "students" , referencedColumnName = "id")
    )
    private Set<Course> courses;
    @ManyToOne
    private Teacher teacher;
}
