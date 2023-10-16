package com.example.spotifyplaylistapp.model.dtos;

import com.example.spotifyplaylistapp.model.entity.SongEntity;
import com.example.spotifyplaylistapp.model.enums.StyleConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
public class SongAddDto {

    @NotBlank
    @Length(min = 3 , max = 20)
    private String performer;

    @NotBlank
    @Length(min = 2 , max = 20)
    private String title;

    @NotNull
    @Positive
    private Integer duration;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date releaseDate;

    @NotNull
    private StyleConstant style;

    public SongEntity toSongEntity (){
        SongEntity songEntity = new SongEntity();
        songEntity.setPerformer(performer);
        songEntity.setTitle(title);
        songEntity.setDuration(duration);
        songEntity.setReleaseDate(releaseDate);
        return songEntity;
    }

}
