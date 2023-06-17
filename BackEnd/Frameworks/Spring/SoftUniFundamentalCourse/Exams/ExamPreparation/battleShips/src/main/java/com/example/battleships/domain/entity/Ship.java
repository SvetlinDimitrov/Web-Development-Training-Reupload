package com.example.battleships.domain.entity;

import com.example.battleships.domain.constants.DefaultEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Ship extends DefaultEntity {

    @Column(columnDefinition = "varchar(255)")
    private String name;
    //        ◦ The length of the values must be between 2 and 10 characters (both numbers are INCLUSIVE)
    //        ◦ The values should be unique in the database
    @Column(columnDefinition = "bigint")
    private Long health;
    //        ◦ The values should be positive numbers
    @Column(columnDefinition = "bigint")
    private Long power;
    //        ◦ The values should be positive numbers
    @Column(columnDefinition = "date")
    private LocalDate created;
    //            ◦ The values should not be future dates

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.MERGE)
    private Category category;

    @ManyToOne(cascade = CascadeType.MERGE , fetch = FetchType.EAGER)
    private User user;

}
