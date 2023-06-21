package com.example.supermarket.domain.entity;

import com.example.supermarket.domain.constants.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "towns")
public class Town extends BaseEntity {
    @Column
    private String name;

    @OneToMany(mappedBy = "town")
    private List<Shop> shops;

    public Town() {
        shops = new ArrayList<>();
    }

    public Town(String name) {
        this();
        this.name = name;
    }
}
