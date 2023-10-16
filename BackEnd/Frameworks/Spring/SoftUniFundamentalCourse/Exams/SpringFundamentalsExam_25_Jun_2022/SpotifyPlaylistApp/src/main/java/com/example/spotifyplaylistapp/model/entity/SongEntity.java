package com.example.spotifyplaylistapp.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String performer;

    @Column(nullable = false)
    private String title;

    private Integer duration;
    private Date releaseDate;

    @ManyToOne
    private StyleEntity style;

    @ManyToMany(mappedBy = "songs")
    private List<UserEntity> users;
}
