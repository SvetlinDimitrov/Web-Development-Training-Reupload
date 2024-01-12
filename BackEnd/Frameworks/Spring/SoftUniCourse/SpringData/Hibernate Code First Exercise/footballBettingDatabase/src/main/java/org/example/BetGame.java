package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bet_games")
@Getter
@Setter
@NoArgsConstructor
public class BetGame implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @Id
    @OneToOne
    @JoinColumn(name = "bet_id")
    private Bet bet;

    @OneToOne
    @JoinColumn(name = "result_prediction")
    private ResultPrediction resultPrediction;


}
