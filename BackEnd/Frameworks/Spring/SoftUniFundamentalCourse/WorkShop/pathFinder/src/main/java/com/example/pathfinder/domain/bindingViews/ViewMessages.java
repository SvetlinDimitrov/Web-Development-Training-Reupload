package com.example.pathfinder.domain.bindingViews;


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
public class ViewMessages {
    private Long id;
    private LocalDate dateTime;
    private String textContent;
    private ViewUser author;
    private ViewUser recipient;
}
