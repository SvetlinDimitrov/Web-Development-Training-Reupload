package com.ltp.gradesubmission.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "student_id", "grade_id" }) })
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Grade {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String score;

    @ManyToOne(targetEntity = Student.class , optional = false)
    @JoinColumn(name = "student_id" , referencedColumnName = "id")
    private Student student;

    @ManyToOne(targetEntity = Course.class , optional = false)
    @JoinColumn(name = "grade_id" , referencedColumnName = "id")
    private Course course;


}
