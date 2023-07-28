package com.example.football.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "teams")
public class Team extends BaseEntity{
    //    • name – accepts char sequences as values where their character length value higher than or equal to 3. The values are unique in the database.
    //    • stadium name – accepts char sequences as values where their character length value higher than or equal to 3.
    //    • fan base – accepts number values that are more than or equal to 1000.
    //    • history – a long and detailed description of team's history with a character length value higher than or equal to 10.
    //        ◦ Note: The teams table has relation with the towns table.

    @Column(nullable = false ,
            unique = true ,
            columnDefinition = "varchar(255)")
    private String name;

    @Column(nullable = false ,
            columnDefinition = "varchar(255)",
            name = "stadium_name")
    private String stadiumName;

    @Column(nullable = false,
            name = "fan_base",
            columnDefinition = "int")
    private Integer fanBase;

    @Column(nullable = false,
            columnDefinition = "text")
    private String history;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Town town;

    @OneToMany(mappedBy = "team")
    private List<Player> playerList;

}
