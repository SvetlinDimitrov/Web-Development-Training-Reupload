package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.enums.StyleConstant;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class StyleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StyleConstant name;

    private String description;
}
