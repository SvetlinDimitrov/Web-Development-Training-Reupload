package com.example.pathfinder.domain.bindingViews;

import com.example.pathfinder.domain.constants.CategoryConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ViewCategories {

    private Long id;
    private CategoryConstant name;
    private String description;

}
