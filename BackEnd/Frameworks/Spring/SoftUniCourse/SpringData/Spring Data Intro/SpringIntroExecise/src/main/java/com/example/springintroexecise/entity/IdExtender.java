package com.example.springintroexecise.entity;

import jakarta.persistence.*;
import lombok.Getter;

@MappedSuperclass
public class IdExtender {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
}
