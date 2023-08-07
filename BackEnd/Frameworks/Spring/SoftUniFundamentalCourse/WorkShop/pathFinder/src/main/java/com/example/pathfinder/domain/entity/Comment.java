package com.example.pathfinder.domain.entity;

import com.example.pathfinder.domain.constants.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
@Builder
public class Comment extends BaseEntity {

    @Column
    private Boolean approved;

    @Column
    private LocalDate created;

    @Column(name = "text_content")
    private String textContent;

    @ManyToOne
    private UserEntity author;


    @ManyToOne
    private Route route;

    public Comment(Long Id, Boolean approved, LocalDate created, String textContent, UserEntity author, Route route) {
        super(Id);
        this.approved = approved;
        this.created = created;
        this.textContent = textContent;
        this.author = author;
        this.route = route;
    }

}
