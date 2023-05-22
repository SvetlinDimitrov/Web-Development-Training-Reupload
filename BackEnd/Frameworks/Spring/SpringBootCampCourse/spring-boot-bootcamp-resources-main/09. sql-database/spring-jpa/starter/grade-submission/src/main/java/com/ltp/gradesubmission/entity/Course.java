package com.ltp.gradesubmission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@EqualsAndHashCode
public class Course {

    public Course() {
       grades = new ArrayList<>();
    }

    public Course(String subject, String code, String description) {
        this();
        this.subject = subject;
        this.code = code;
        this.description = description;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String subject;

    @Column(unique = true)
    private String code;

    @Column
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course" , cascade = CascadeType.REMOVE)
    private List<Grade> grades;
}
