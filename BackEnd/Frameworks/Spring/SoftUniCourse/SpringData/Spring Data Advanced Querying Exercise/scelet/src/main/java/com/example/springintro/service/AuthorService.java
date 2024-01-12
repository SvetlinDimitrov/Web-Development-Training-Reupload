package com.example.springintro.service;

import com.example.springintro.model.entity.Author;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();
    List<Author> authorsSearch(String prefix);
    TreeMap<String , Integer> totalBookCopies();
}
