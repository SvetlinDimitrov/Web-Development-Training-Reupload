package com.example.spring_mapper_exercise.domain.entities;

import com.example.spring_mapper_exercise.domain.enums.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "orders")
@Getter
@Setter


public class Order extends BaseEntity{
    @ManyToOne(targetEntity = User.class)
    private User user;

    @ManyToMany
    private List<Game> gameList;

    public Order() {
        this.gameList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {


        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(user, order.user) &&
                Objects.equals(gameList, order.gameList) &&
                Objects.equals(getId() , order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, gameList , getId());
    }
}
