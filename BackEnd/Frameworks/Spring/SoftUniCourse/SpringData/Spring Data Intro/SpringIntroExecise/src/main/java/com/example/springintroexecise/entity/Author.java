package com.example.springintroexecise.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "authors")
@AllArgsConstructor
public class Author extends IdExtender{
    @Column(name = "first_name" , nullable = true)
    private String firstName;

    @Column(name ="last_name" ,  nullable = false)
    private String lastName;

    @OneToMany(targetEntity = Book.class , mappedBy = "author" , fetch = FetchType.EAGER)
    private Set<Book> books;

    public Author() {
        books = new HashSet<>();
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        books = new HashSet<>();
    }
}
