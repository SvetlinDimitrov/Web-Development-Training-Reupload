package com.example.pathfinder.domain.entity;

import com.example.pathfinder.domain.constants.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Column
    private Boolean approved;

    @Column(columnDefinition = "datetime(6)")
    @Past
    private LocalDate created;

    @Column(name = "text_content" , columnDefinition = "text")
    private String textContent;

    @ManyToOne
    private User author;


    @ManyToOne
    private Route route;
}
