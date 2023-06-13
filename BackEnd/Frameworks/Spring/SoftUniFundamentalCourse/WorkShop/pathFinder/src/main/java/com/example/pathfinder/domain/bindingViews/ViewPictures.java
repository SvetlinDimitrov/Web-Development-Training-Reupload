package com.example.pathfinder.domain.bindingViews;


import com.example.pathfinder.domain.entity.Route;
import com.example.pathfinder.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewPictures {

    private Long id;
    private String title;
    private String url;
    private ViewUser author;
    private ViewRoute route;

}
