package com.ltp.gradesubmission.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
        this.grades = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;

    @NonNull
    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "birth_date", nullable = false)
    @Past(message = "The birth date must be in the past")
    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Grade> grades;
    
}
