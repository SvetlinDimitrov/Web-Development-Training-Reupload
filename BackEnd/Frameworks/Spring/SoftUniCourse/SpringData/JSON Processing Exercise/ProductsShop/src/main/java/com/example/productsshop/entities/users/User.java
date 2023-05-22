package com.example.productsshop.entities.users;

import com.example.productsshop.entities.CONSTANTS.BaseEntity;
import com.example.productsshop.entities.Dtos.Json.UserDtoSoldResponse;
import com.example.productsshop.entities.Dtos.Json.usersAndProducts.AllUsers;
import com.example.productsshop.entities.Dtos.Json.usersAndProducts.SoldProductCollectionDto;
import com.example.productsshop.entities.Dtos.Json.usersAndProducts.UserDto;
import com.example.productsshop.entities.products.Product;
import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name",
            nullable = false)
    private String lastName;

    @Column
    private Integer age;

    @OneToMany(targetEntity = Product.class, mappedBy = "buyer", fetch = FetchType.EAGER)
    private List<Product> soldProducts;

    @OneToMany(targetEntity = Product.class, mappedBy = "seller" ,fetch = FetchType.EAGER)
    private List<Product> buyProducts;

    @OneToMany (fetch = FetchType.EAGER)
    private Set<User> friends;

    public User() {
        super();
        this.soldProducts = new ArrayList<>();
        this.buyProducts = new ArrayList<>();
        this.friends = new HashSet<>();
    }

    public static UserDtoSoldResponse userDtoSoldResponse(User user) {
        UserDtoSoldResponse userDtoSoldResponse = new UserDtoSoldResponse();
        userDtoSoldResponse.setFirstName(user.getFirstName());

        userDtoSoldResponse.setLastName(user.getLastName());

        userDtoSoldResponse.setSoldProducts(user.getSoldProducts().stream()
                .map(Product::toProductDtoSellerAndBuyer)
                .toList());
        return userDtoSoldResponse;
    }

    public static UserDto toUserDto(User user){
        SoldProductCollectionDto soldProductCollectionDto = Product.toSoldProductCollectionDto(user.getSoldProducts());
        return new UserDto(user.getFirstName(), user.getLastName(), user.getAge(), soldProductCollectionDto);
    }
    public static AllUsers toAllUsers(List<User> users){
        List<UserDto> list = users.stream()
                .map(User::toUserDto)
                .toList();
        return new AllUsers(list.size() , list);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public List<Product> getBuyProducts() {
        return buyProducts;
    }

    public void setBuyProducts(List<Product> buyProducts) {
        this.buyProducts = buyProducts;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }
}
