package University.System;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
public class Teacher extends Person{
    @Column
    private String email;
    @Column(name = "salary_per_hour")
    private Double salary;
    @OneToMany
    private Set<Course> courses;
}
