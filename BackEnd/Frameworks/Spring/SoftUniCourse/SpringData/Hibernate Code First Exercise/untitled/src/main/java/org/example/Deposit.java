package org.example;

import lombok.*;
import javax.persistence.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "groupp" , length = 20)
    private String group;
    @Column(name = "start_date")
    private LocalDate date;
    @Column
    private Double amount;
    @Column
    private Double interest;
    @Column
    private  Double charge;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    @Column(name = "expired")
    private Boolean isExpired;
}
