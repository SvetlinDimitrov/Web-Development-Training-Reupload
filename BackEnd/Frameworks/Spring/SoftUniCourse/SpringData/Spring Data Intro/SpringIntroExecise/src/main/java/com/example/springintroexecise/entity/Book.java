package com.example.springintroexecise.entity;

import com.example.springintroexecise.entity.enums.AgeRestriction;
import com.example.springintroexecise.entity.enums.EditionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "books")
@NoArgsConstructor

public class Book extends IdExtender{
    @Column(name = "age_restriction" , nullable = false)
    @Enumerated
    private AgeRestriction ageRestriction;

    @Column( nullable = false)
    private int copies;

    @Column(nullable = true , length = 1000)
    private String description;

    @Enumerated
    @Column(name = "edition_type")
    private EditionType editionType;

    @Column( nullable = false)
    private BigDecimal price;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column( nullable = false)
    private String title;

    @ManyToOne
    private Author author;

    @ManyToMany
    private Set<Category> category;

    public Book(String title,EditionType editionType, BigDecimal price, LocalDate releaseDate,AgeRestriction ageRestriction,  Author author, Set<Category> category ,int copies) {
        this.ageRestriction = ageRestriction;
        this.copies = copies;
        this.editionType = editionType;
        this.price = price;
        this.releaseDate = releaseDate;
        this.title = title;
        this.author = author;
        this.category = category;
    }
}
