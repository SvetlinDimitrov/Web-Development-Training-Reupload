package com.example.springintroexecise.entity;

import com.example.springintroexecise.entity.enums.AgeRestriction;
import com.example.springintroexecise.entity.enums.EditionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
public class Book extends IdExtender{
    @Column(name = "age_restriction" , nullable = false)
    @Enumerated
    private AgeRestriction ageRestriction;

    @Column( nullable = false)
    private int copies;

    @Column(nullable = true , columnDefinition = "varchar(255)")
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
    private Set<Category> category = new HashSet<>();

    public Book setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
        return this;
    }

    public Book setCopies(int copies) {
        this.copies = copies;
        return this;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public Book setEditionType(EditionType editionType) {
        this.editionType = editionType;
        return this;
    }

    public Book setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Book setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Book setCategory(Set<Category> category) {
        this.category = category;
        return this;
    }
}
