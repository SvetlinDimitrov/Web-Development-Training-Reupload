package com.example.supermarket.domain.entity;

import com.example.supermarket.domain.constants.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category  extends BaseEntity {

    @Column(unique = true)
    @Length(min = 2 , message = "Name must be minimum two characters!")
    @NotNull
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category() {
        products = new ArrayList<>();
    }

    public Category(String name) {
        this();
        this.name = name;
    }
}
