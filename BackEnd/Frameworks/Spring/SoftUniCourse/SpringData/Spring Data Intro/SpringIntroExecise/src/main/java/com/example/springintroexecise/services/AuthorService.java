package com.example.springintroexecise.services;

import com.example.springintroexecise.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void registerAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> authorsWhoHaveAtLeastOneBookBefore1990();
    List<String> allAuthorsOrderByBookCount();
}
