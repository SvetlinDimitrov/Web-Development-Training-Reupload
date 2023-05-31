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
@Table(name = "shops")
public class Shop extends BaseEntity{
    @Column
    @NotNull
    @Length(min = 2 , message = "address must be at least 2 characters long")
    private String address;

    @Column
    @Length(min = 2 , message = "name must be at least 2 characters long")
    private String name;

    @ManyToOne(targetEntity = Town.class)
    @JoinColumn(referencedColumnName = "id")
    private Town town;

    @OneToMany(mappedBy = "shop")
    private List<Seller> sellers;

    @OneToMany(mappedBy = "shop")
    private List<Product> products;

    public Shop() {
        products = new ArrayList<>();
        sellers = new ArrayList<>();
    }
}
