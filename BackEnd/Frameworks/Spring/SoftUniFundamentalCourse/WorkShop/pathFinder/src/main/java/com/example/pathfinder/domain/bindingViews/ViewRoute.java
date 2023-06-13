package com.example.pathfinder.domain.bindingViews;
import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.entity.Categorie;
import com.example.pathfinder.domain.entity.Picture;
import com.example.pathfinder.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewRoute  {
    private Long id;
    private String gpxCoordinates;
    private String description;
    private Level level;
    private String name;
    private ViewUser author;
    private String videoUrl;
    private List<ViewPictures> pictures;
    private Set<ViewCategories> roles;
}
