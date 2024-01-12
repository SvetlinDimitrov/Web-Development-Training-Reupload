package com.example.springintroexecise.services;

import com.example.springintroexecise.entity.Author;
import com.example.springintroexecise.entity.Book;
import com.example.springintroexecise.entity.Category;
import com.example.springintroexecise.entity.enums.AgeRestriction;
import com.example.springintroexecise.entity.enums.EditionType;
import com.example.springintroexecise.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImp implements BookService {
    private BookRepo bookRepo;
    private AuthorService authorService;
    private CategoryService categoryService;
    private static final String BOOKS_FILE_NAME = "src\\main\\resources\\files\\books.txt";

    @Autowired
    public BookServiceImp(BookRepo bookRepo, AuthorService authorService, CategoryService categoryService) {
        this.bookRepo = bookRepo;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void registerBooks() throws IOException {
        if(bookRepo.findAll().isEmpty()){
            List<Book> books = Files.readAllLines(Path.of(BOOKS_FILE_NAME))
                    .stream()
                    .map(row -> {
                        String[] data = row.split("\\s+");

                        Author author = authorService.getRandomAuthor();

                        EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];

                        LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));

                        int copies = Integer.parseInt(data[2]);

                        BigDecimal price = new BigDecimal(data[3]);
                        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];

                        String title = Arrays.stream(data)
                                .skip(5)
                                .collect(Collectors.joining(" "));

                        Set<Category> categories = categoryService.getRandomCategories();

                        return new Book()
                                .setTitle(title)
                                .setEditionType(editionType)
                                .setPrice(price)
                                .setReleaseDate(releaseDate)
                                .setAgeRestriction(ageRestriction)
                                .setAuthor(author)
                                .setCategory(categories)
                                .setCopies(copies);
                    }).toList();
            bookRepo.saveAll(books);
        }
    }
    @Override
    public List<String> booksAfter2000() {
        return bookRepo.findBooksByReleaseDateAfter(LocalDate.of(2000 , 1,1))
                .stream()
                .map(Book::getTitle)
                .toList();
    }

    @Override
    public List<String> findAllBooksByGeorge_PowellOrderByDateAndBookTitle() {
        return bookRepo.findBookByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitleAsc("George","Powell")
                .stream()
                .map(b-> String.format("%s %s %d" , b.getTitle() , b.getReleaseDate() , b.getCopies()))
                .toList();
    }
}
