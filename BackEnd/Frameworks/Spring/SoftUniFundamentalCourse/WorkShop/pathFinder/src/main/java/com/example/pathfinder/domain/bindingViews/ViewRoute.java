package com.example.pathfinder.domain.bindingViews;

import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.entity.Route;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewRoute {
    private Long id;
    private String gpxCoordinates;
    private String description;
    private Level level;
    private String name;
    private String author;
    private Long authorId;
    private String videoUrl;
    private List<ViewPictures> pictures = new ArrayList<>();
    private Set<ViewCategories> roles = new HashSet<>();

    public ViewRoute(Route route) {
        this.id = route.getId();
        this.gpxCoordinates = route.getGpxCoordinates();
        this.description = route.getDescription();
        this.level = route.getLevel();
        this.name = route.getName();
        this.videoUrl = route.getVideoUrl();
        this.pictures = route.getPictures()
                .stream()
                .map(ViewPictures::new)
                .collect(Collectors.toList());
        this.roles = route.getRoles()
                .stream()
                .map(ViewCategories::new)
                .collect(Collectors.toSet());
        this.author = route.getAuthor().getFullName();
        this.authorId = route.getAuthor().getId();
    }
}
