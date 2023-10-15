package com.likebookapp.model.dtos;

import com.likebookapp.model.entity.PostEntity;
import com.likebookapp.model.enums.MoodConstance;
import lombok.Data;

@Data
public class PostView {

    private Long id;
    private String content;
    private String user;
    private MoodConstance mood;
    private Long likes;

    public PostView (PostEntity entity){
        this.id = entity.getId();
        this.content = entity.getContent();
        this.user = entity.getUser().getUsername();
        this.mood = entity.getMoodEntities().getName();
        this.likes = (long) entity.getUserLikes().size();
    }
}
