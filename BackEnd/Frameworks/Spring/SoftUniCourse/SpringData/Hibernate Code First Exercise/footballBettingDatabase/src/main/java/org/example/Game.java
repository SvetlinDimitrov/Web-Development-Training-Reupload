package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "games")
@Getter
@Setter
@NoArgsConstructor
public class Game  extends IdExtender{
    @OneToOne
    @JoinColumn(name = "home_team")
    private Teams homeTeam;

    @OneToOne
    @JoinColumn(name = "away_team")
    private Teams awayTeam;

    @Column(name = "home_teams_goals")
    private Integer homeTeamGoals;

    @Column(name = "away_team_goals")
    private Integer awayTeamGoals;

    @Column(name = "date_time")
    private LocalDate dateTime;

    @Column(name = "home_team_win_bet_rate")
    private Double homeTeamWinBetRate;

    @Column(name = "away_team_win_bet_rate")
    private Double awayTeamWinBetRate;

    @Column(name = "draw_game_bet_rate")
    private Double drawGameBetRate;

    @OneToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @OneToOne
    @JoinColumn(name = "round_id")
    private Round round;
}
