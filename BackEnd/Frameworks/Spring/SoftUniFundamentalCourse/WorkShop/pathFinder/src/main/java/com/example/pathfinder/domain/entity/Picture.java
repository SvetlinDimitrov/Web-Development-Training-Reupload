package com.example.pathfinder.domain.entity;

import com.example.pathfinder.domain.constants.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pictures")
public class Picture extends BaseEntity {
    @Column
    private String title;

    @Column
    private String url;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private Route route;
}
