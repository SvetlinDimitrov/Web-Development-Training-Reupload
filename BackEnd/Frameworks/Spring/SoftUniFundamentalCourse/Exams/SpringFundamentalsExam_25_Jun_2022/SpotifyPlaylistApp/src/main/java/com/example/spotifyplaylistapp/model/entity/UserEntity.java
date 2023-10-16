package com.example.spotifyplaylistapp.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false , unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "users_songs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<SongEntity> songs;
}
