package com.example.spotifyplaylistapp.model.dtos;

import com.example.spotifyplaylistapp.model.entity.UserEntity;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserView {

    private Long id;
    private String username;
    private String email;
    private List<SongView> songs;

    public UserView(UserEntity user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.songs = user.getSongs()
                .stream()
                .map(SongView::new)
                .collect(Collectors.toList());
    }
}
