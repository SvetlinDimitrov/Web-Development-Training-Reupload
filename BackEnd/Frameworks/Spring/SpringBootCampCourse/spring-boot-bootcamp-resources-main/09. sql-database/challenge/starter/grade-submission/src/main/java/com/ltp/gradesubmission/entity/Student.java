package com.ltp.gradesubmission.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor

@Entity
@Table(name = "student")
public class Student {

    public Student() {
        grades = new ArrayList<>();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @Past(message = "The birth date must be in the past")
    @NonNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    
    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Grade> grades;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "student_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id" , referencedColumnName = "id")
    )
    private List<Course> courses;

}
