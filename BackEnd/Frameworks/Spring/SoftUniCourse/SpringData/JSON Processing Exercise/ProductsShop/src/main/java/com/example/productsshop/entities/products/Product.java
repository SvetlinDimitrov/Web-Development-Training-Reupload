package com.example.productsshop.entities.products;

import com.example.productsshop.entities.CONSTANTS.BaseEntity;
import com.example.productsshop.entities.Dtos.Json.ProductDtoSellerAndBuyer;
import com.example.productsshop.entities.Dtos.Json.usersAndProducts.ProductDto2;
import com.example.productsshop.entities.Dtos.Json.usersAndProducts.SoldProductCollectionDto;
import com.example.productsshop.entities.users.User;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Entity
@AllArgsConstructor

public class Product extends BaseEntity {

    @Expose
    private String name;

    @Column
    @Expose
    private BigDecimal price;

    @ManyToOne(targetEntity = User.class)
    private User buyer;

    @ManyToOne(targetEntity = User.class)
    private User seller;

    @ManyToMany
    private Set<Category> categories;

    public Product() {
        categories = new HashSet<>();
    }

    public static ProductDtoSellerAndBuyer toProductDtoSellerAndBuyer(Product product){
        ProductDtoSellerAndBuyer productDtoSellerAndBuyer = new ProductDtoSellerAndBuyer();
        productDtoSellerAndBuyer.setName(product.getName());
        productDtoSellerAndBuyer.setPrice(product.getPrice());
        productDtoSellerAndBuyer.setBuyerFirstName(product.getBuyer().getFirstName());
        productDtoSellerAndBuyer.setBuyerLastName(product.getBuyer().getLastName());
        return productDtoSellerAndBuyer;
    }

    public static ProductDto2 toProductDto2(Product product){
        return new ProductDto2(product.getName() , product.getPrice());
    }

    public static SoldProductCollectionDto toSoldProductCollectionDto(List<Product> productList){
        List<ProductDto2> list = productList.stream()
                .map(Product::toProductDto2)
                .toList();
        return new SoldProductCollectionDto(list.size(), list);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public User getBuyer() {
        return buyer;
    }

    public User getSeller() {
        return seller;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
