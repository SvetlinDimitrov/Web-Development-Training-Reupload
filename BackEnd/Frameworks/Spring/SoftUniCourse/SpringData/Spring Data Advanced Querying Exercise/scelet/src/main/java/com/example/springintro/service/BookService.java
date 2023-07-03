package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.DTO.ShowingInfo;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);
    List<Book> booksTitlesByAgeRestriction (String ageRes);
    List<Book> goldenBooks();
    List<Book> booksByPrice();
    List<Book> notReleasedBooks(String year);
    List<Book> booksReleasedBeforeDate(String year);
    List<Book> booksSearch(String suffix);
    List<Book> bookTitlesSearch(String prefix);
    int countBooks (long length);

    ShowingInfo reducedBook(String title);


}
