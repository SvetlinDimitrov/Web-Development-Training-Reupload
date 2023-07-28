package com.example.football.models.entity;

import com.example.football.util.enums.PositionState;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "players")
public class Player extends BaseEntity {
    //    • first name – accepts char sequences as values where their character length value higher than 2.
    //    • last name – accepts char sequences as values where their character length value higher than 2.
    //    • email – accepts valid email addresses (must contains '@' and '.' – a dot). The values are unique in the database.
    //    • birth date – a date in the "dd/MM/yyyy" format.
    //    • position – one of the following – ATT, MID, DEF.
    //        ◦ Note: The players table has relations with the towns, teams and stats tables.

    @Column(nullable = false,
            columnDefinition = "varchar(255)",
            name = "first_name")
    private String firstName;

    @Column(nullable = false,
            columnDefinition = "varchar(255)",
            name = "last_name")
    private String lastName;

    @Column(nullable = false, unique = true, columnDefinition = "varchar(255)")
    private String email;

    @Column(nullable = false,
            columnDefinition = "date",
            name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, columnDefinition = "int")
    private PositionState position;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Stat stat;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Town town;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Team team;

}
