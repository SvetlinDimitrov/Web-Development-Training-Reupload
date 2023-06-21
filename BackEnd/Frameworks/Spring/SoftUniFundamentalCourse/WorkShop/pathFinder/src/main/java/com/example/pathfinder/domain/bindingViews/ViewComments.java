package com.example.pathfinder.domain.bindingViews;

import com.example.pathfinder.domain.entity.Route;
import com.example.pathfinder.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewComments {
    private Long id;
    private Boolean approved;
    private LocalDate created;
    private String textContent;
    private ViewUser author;
    private ViewRoute route;
}