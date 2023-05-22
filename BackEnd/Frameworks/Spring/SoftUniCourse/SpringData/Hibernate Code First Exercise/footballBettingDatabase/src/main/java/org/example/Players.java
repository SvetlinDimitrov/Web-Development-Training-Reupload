package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
public class Players extends IdExtender{
    @Column
    private String name;

    @Column(name = "squad_number")
    private String squadNumber;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Teams team;

    @OneToOne
    @JoinColumn(name = "position_id")
    private Positions position;

    @Column(name = "is_injured")
    private Boolean isInjured;
}
