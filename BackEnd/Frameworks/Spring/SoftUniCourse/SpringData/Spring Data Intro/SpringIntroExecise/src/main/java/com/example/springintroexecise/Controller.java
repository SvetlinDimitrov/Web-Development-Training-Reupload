package com.example.springintroexecise;


import com.example.springintroexecise.services.AuthorService;
import com.example.springintroexecise.services.BookService;
import com.example.springintroexecise.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Controller implements CommandLineRunner {

    private CategoryService categoryService;
    private AuthorService authorService;
    private BookService bookService;

    @Autowired
    public Controller(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        authorService.registerAuthors();
        categoryService.registerCategory();
        bookService.registerBooks();
        bookService.booksAfter2000().forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------");
        authorService.authorsWhoHaveAtLeastOneBookBefore1990().forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------");
        authorService.allAuthorsOrderByBookCount().forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------");
        bookService.findAllBooksByGeorge_PowellOrderByDateAndBookTitle().forEach(System.out::println);
    }
}
