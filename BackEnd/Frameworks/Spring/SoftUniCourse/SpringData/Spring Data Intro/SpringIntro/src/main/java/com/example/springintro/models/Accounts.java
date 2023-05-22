package com.example.springintro.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Accounts {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal balance;

    @ManyToOne
    private User user;

    public Accounts() {}

    public Accounts(BigDecimal balance, User user) {
        this.balance = balance;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

