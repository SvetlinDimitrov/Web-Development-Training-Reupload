package com.example.pathfinder.domain.entity;

import com.example.pathfinder.domain.constants.BaseEntity;
import com.example.pathfinder.domain.constants.CategoryConstant;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Categorie extends BaseEntity {
    @Column
    @Enumerated(EnumType.STRING)
    private CategoryConstant name;

    public Categorie setName(CategoryConstant name) {
        this.name = name;
        return this;
    }

    public Categorie setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column
    private String description;

    public Categorie(Long Id, CategoryConstant name, String description) {
        super(Id);
        this.name = name;
        this.description = description;
    }
}
