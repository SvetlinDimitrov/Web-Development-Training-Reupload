package com.example.pathfinder.domain.entity;

import com.example.pathfinder.domain.constants.BaseEntity;
import com.example.pathfinder.domain.constants.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "routes")
public class Route extends BaseEntity {
    @Column(name = "gpx_coordinates" , columnDefinition = "longtext")
    private String gpxCoordinates;

    @Column(columnDefinition = "text")
    private String description;

    @Column(columnDefinition = "varchar(255)")
    @Enumerated
    private Level level;

    @Column(columnDefinition = "varchar(255)")
    private String name;

    @ManyToOne
    private User author;

    @Column(name = "video_url" , columnDefinition = "varchar(255)")
    private String videoUrl;

    @OneToMany(mappedBy = "route")
    private List<Picture> pictures;

    @ManyToMany
    @JoinTable(
            name = "routes_categories",
            joinColumns = @JoinColumn(
                    name = "route_entity_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "categories_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Categorie> roles;
}
