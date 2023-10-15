package com.likebookapp.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class PostEntity {

    @Id
    @GeneratedValue(strategy =   GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    private UserEntity user;

    @ManyToMany(mappedBy = "likedPosts")
    private List<UserEntity> userLikes;

    @ManyToOne
    private MoodEntity moodEntities;
}
