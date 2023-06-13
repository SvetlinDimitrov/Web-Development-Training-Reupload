package com.example.pathfinder.domain.entity;

import com.example.pathfinder.domain.constants.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pictures")
public class Picture extends BaseEntity {
    @Column(columnDefinition = "varchar(255)")
    private String title;

    @Column(columnDefinition = "text")
    private String url;

    @ManyToOne
    private User author;

    @ManyToOne
    private Route route;
}
