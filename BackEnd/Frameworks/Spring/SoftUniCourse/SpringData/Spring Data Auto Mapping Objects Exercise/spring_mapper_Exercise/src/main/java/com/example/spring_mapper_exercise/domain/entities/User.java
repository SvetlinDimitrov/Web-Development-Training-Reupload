package com.example.spring_mapper_exercise.domain.entities;

import com.example.spring_mapper_exercise.domain.enums.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter

public class User extends BaseEntity {
    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.MERGE)
    private List<Game> games;

    @Column(name = "is_admin")
    private Boolean isAdmit;


    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER , cascade = CascadeType.MERGE)
    private List<Order> order;

    public User() {
        this.games = new ArrayList<>();
        this.isAdmit = false;
        this.order = new ArrayList<>();
    }

    public User(String email, String password, String fullName) {
        this();
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(fullName, user.fullName) &&
                Objects.equals(games, user.games) &&
                Objects.equals(isAdmit, user.isAdmit) &&
                Objects.equals(order, user.order) &&
                Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, fullName, games, isAdmit, order , getId());
    }
}
