package com.example.books.service;

import com.example.books.entity.Author;
import com.example.books.repos.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private AuthorRepository authorRepository;

    public void seedAuthors() {
        if (authorRepository.count() == 0) {
            authorRepository.saveAll(List.of(
                    new Author("Pesho"),
                    new Author("Sasho"),
                    new Author("Gosho"),
                    new Author("Svetlio"),
                    new Author("Ivan"),
                    new Author("Dido")
                    )
            );
        }
    }
}
