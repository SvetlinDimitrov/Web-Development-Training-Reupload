package com.example.books.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SeedService {
    private AuthorService authorService;
    private BookService bookService;

    public void seedAll(){
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
