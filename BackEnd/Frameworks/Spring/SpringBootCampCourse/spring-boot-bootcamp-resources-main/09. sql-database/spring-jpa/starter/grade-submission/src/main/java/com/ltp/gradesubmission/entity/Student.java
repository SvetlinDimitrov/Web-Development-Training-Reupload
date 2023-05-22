package com.ltp.gradesubmission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@EqualsAndHashCode
public class Student {

    public Student() {
        this.gradeList = new ArrayList<>();
    }

    public Student(String name, LocalDate birthDate) {
        this();
        this.name = name;
        this.birthDate = birthDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false , name = "birth_date")
    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "student" , cascade = CascadeType.REMOVE)
    private List<Grade> gradeList;

}
