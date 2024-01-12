package com.example.spring_mapper_exercise.domain.entities;

import com.example.spring_mapper_exercise.domain.enums.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "games")
@Getter
@Setter
@NoArgsConstructor
public class Game extends BaseEntity {
    @Column
    private String title;
    @Column
    private String trailer;
    @Column(name = "image_thumbnail")
    private String imageThumbnail;
    @Column
    private BigDecimal size;
    @Column
    private BigDecimal price;
    @Column
    private String description;
    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(title, game.title) &&
                Objects.equals(trailer, game.trailer) &&
                Objects.equals(imageThumbnail, game.imageThumbnail) &&
                Objects.equals(size, game.size) && Objects.equals(price, game.price) &&
                Objects.equals(description, game.description) &&
                Objects.equals(releaseDate, game.releaseDate) &&
                Objects.equals(getId() , game.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, trailer, imageThumbnail, size, price, description, releaseDate, getId());
    }
}
