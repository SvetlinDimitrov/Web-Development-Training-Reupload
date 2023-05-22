package com.example.springintroexecise.services;

import com.example.springintroexecise.entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void registerBooks () throws IOException;

    List<String> booksAfter2000();

    List<String> findAllBooksByGeorge_PowellOrderByDateAndBookTitle();

}

