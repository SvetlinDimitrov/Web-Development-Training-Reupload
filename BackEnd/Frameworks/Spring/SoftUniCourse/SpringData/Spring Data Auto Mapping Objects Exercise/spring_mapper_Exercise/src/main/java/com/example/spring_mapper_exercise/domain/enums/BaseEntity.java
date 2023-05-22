package com.example.spring_mapper_exercise.domain.enums;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
