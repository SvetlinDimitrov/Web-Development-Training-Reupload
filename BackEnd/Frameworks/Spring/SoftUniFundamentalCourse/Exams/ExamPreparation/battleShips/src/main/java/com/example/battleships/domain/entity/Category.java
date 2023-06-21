package com.example.battleships.domain.entity;

import com.example.battleships.domain.constants.CategoryConstants;
import com.example.battleships.domain.constants.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends DefaultEntity {

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryConstants name;

    @Column(columnDefinition = "text")
    private String description;

}
