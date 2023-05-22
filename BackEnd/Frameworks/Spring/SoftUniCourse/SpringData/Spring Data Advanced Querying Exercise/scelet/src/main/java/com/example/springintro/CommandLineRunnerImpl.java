package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        bookService.reducedBook(s)
                .forEach(a-> System.out.printf("%s %s %s %s%n",
                        a.getTitle() , a.getEditionType().name() ,a.getEditionType().name() , a.getPrice()));


    }

    private void Total_Book_Copies() {
        //TODO fix this shit number10
        authorService.totalBookCopies()
                .forEach((key, value) -> System.out.printf("%s - %d%n", key, value));
    }

    private void Count_Books(String s) {
        long input = Long.parseLong(s);
        System.out.println(bookService.countBooks(input));
    }

    private void Book_Titles_Search(String s) {
        bookService.bookTitlesSearch(s)
                .forEach(e-> System.out.println(e.getTitle()));
    }

    private void Books_Search(String s) {
        bookService.booksSearch(s)
                .forEach(e-> System.out.println(e.getTitle()));
    }

    private void Authors_Search(String s) {
        authorService.authorsSearch(s)
                .forEach(e-> System.out.println(e.getFirstName() + " " + e.getLastName()));
    }

    private void Books_Released_Before_Date(String s) {
        for (Book book : bookService.booksReleasedBeforeDate(s)) {
            System.out.printf("%s %s %s%n" , book.getTitle() , book.getEditionType().toString() , book.getPrice());
        }
    }

    private void Not_Released_Books(String s) {
        bookService.notReleasedBooks(s).forEach(e-> System.out.println(e.getTitle()));
    }

    private void Books_by_Price() {
        bookService.booksByPrice().forEach(e-> System.out.printf("%s - $%s%n",e.getTitle() , e.getPrice()));
    }

    private void Golden_Books() {
        bookService.goldenBooks().forEach(e-> System.out.println(e.getTitle()));
    }

    private void Books_Titles_by_Age_Restriction() {
        bookService.booksTitlesByAgeRestriction(new Scanner(System.in).nextLine().toUpperCase())
                .forEach(e-> System.out.println(e.getTitle()));
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
