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
    @Column(name = "gpx_coordinates" ,columnDefinition = "longtext")
    private String gpxCoordinates;

    @Column(columnDefinition = "text")
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column
    private String name;

    @ManyToOne
    private User author;

    @Column(name = "video_url")
    private String videoUrl;

    @OneToMany(mappedBy = "route" , fetch = FetchType.LAZY)
    private List<Picture> pictures;

    @ManyToMany(fetch = FetchType.LAZY)
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
