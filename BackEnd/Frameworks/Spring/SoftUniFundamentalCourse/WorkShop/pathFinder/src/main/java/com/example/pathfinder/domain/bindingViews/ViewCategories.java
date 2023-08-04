package com.example.pathfinder.domain.bindingViews;

import com.example.pathfinder.domain.constants.CategoryConstant;
import com.example.pathfinder.domain.entity.Categorie;
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

    public ViewCategories(Categorie categorie) {
        this.id = categorie.getId();
        this.name = categorie.getName();
        this.description = categorie.getDescription();
    }
}
