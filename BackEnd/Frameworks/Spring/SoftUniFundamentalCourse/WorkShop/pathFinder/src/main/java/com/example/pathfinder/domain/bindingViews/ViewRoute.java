package com.example.pathfinder.domain.bindingViews;

import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.entity.Route;
import lombok.*;

import java.util.*;
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
    private List<ViewPicture> pictures = new ArrayList<>();
    private Set<ViewCategorie> roles = new HashSet<>();

    public ViewRoute(Route route) {
        this.id = route.getId();
        this.gpxCoordinates = route.getGpxCoordinates();
        this.description = route.getDescription();
        this.level = route.getLevel();
        this.name = route.getName();
        this.videoUrl = route.getVideoUrl();
        this.pictures = route.getPictures()
                .stream()
                .map(ViewPicture::new)
                .collect(Collectors.toList());
        this.roles = route.getRoles()
                .stream()
                .map(ViewCategorie::new)
                .collect(Collectors.toSet());
        this.author = route.getAuthor().getFullName();
        this.authorId = route.getAuthor().getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewRoute viewRoute = (ViewRoute) o;
        return Objects.equals(id, viewRoute.id) && Objects.equals(gpxCoordinates, viewRoute.gpxCoordinates) && Objects.equals(description, viewRoute.description) && level == viewRoute.level && Objects.equals(name, viewRoute.name) && Objects.equals(author, viewRoute.author) && Objects.equals(authorId, viewRoute.authorId) && Objects.equals(videoUrl, viewRoute.videoUrl) && Objects.equals(pictures, viewRoute.pictures) && Objects.equals(roles, viewRoute.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gpxCoordinates, description, level, name, author, authorId, videoUrl, pictures, roles);
    }
}
