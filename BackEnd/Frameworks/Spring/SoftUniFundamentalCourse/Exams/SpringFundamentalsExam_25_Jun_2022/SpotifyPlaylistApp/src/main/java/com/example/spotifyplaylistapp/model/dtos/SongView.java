package com.example.spotifyplaylistapp.model.dtos;

import com.example.spotifyplaylistapp.model.entity.SongEntity;
import com.example.spotifyplaylistapp.model.entity.StyleEntity;
import com.example.spotifyplaylistapp.model.enums.StyleConstant;
import lombok.Data;

import java.text.SimpleDateFormat;

@Data
public class SongView {

    private Long id;
    private String performer;
    private String title;
    private Integer duration;
    private String releaseDate;
    private StyleConstant style;

    public SongView (SongEntity songEntity){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        this.id = songEntity.getId();
        this.performer=songEntity.getPerformer();
        this.title = songEntity.getTitle();
        this.duration = songEntity.getDuration();
        this.releaseDate = dateFormat.format(songEntity.getReleaseDate());
        this.style = songEntity.getStyle().getName();

    }
}
