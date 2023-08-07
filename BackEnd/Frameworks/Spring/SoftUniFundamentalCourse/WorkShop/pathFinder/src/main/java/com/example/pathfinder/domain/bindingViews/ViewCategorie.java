package com.example.pathfinder.domain.bindingViews;

import com.example.pathfinder.domain.constants.CategoryConstant;
import com.example.pathfinder.domain.entity.Categorie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ViewCategorie {

    private Long id;
    private CategoryConstant name;
    private String description;

    public ViewCategorie(Categorie categorie) {
        this.id = categorie.getId();
        this.name = categorie.getName();
        this.description = categorie.getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewCategorie that = (ViewCategorie) o;
        return Objects.equals(id, that.id) && name == that.name && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
