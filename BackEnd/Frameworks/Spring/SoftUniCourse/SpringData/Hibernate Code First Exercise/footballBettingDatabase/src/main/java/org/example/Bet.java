package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bets")
@Getter
@Setter
@NoArgsConstructor
public class Bet extends IdExtender{
    @Column(name = "bet_money")
    private Double betMoney;

    @Column(name = "date_time")
    private LocalDate dateTime;

    @OneToOne
    private User user;
}
