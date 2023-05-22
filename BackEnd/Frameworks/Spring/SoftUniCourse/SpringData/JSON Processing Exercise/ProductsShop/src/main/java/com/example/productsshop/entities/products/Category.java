package com.example.productsshop.entities.products;

import com.example.productsshop.entities.CONSTANTS.BaseEntity;
import com.google.gson.annotations.Expose;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category extends BaseEntity {
    @Column
    @Expose
    private String name;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(getId(), category.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name , getId());
    }
}
