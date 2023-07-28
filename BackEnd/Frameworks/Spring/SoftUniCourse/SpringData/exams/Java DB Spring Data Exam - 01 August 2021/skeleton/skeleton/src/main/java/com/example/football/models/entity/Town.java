package com.example.football.models.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "towns")
public class Town extends BaseEntity {
    //    • name – accepts char sequences as values where their character length value higher than or equal to 2. The values are unique in the database.
    //    • population – accepts number values (must be a positive number), 0 as a value is exclusive.
    //    • travel guide – a long and detailed description of all known places with a character length value higher than or equal to 10.

    @Column(nullable = false ,
            unique = true,
            columnDefinition = "varchar(255)")
    private String name;

    @Column(nullable = false ,
            columnDefinition = "int")
    private Integer population;

    @Column(nullable = false,
            columnDefinition = "text",
            name = "travel_guide")
    private String travelGuide;

    @OneToMany(mappedBy = "town")
    private List<Team> teamList  = new ArrayList<>();

    @OneToMany(mappedBy = "town")
    private List<Player> playerList = new ArrayList<>();
}
