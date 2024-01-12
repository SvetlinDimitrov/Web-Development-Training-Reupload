package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "player_statistics")
@Getter
@Setter
@NoArgsConstructor
public class PlayerStatistics implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Players player;

    @Column(name = "scored_goals")
    private Integer scoredGoals;

    @Column(name = "player_assists")
    private Integer playerAssists;

    @Column(name = "played_minutes")
    private Double playedMinutes;
}
