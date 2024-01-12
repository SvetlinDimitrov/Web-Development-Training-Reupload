package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.model.entity.DTO.ShowingInfo;
import com.example.springintro.model.entity.Enum.AgeRestriction;
import com.example.springintro.model.entity.Enum.EditionType;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
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
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> booksTitlesByAgeRestriction(String ageRes) {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRes);
        return bookRepository.findAllByAgeRestriction(ageRestriction);
    }

    @Override
    public List<Book> goldenBooks() {
        return bookRepository.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD , 5000);
    }

    @Override
    public List<Book> booksByPrice() {
        return bookRepository.findAllByPriceLessThanOrPriceGreaterThan(new BigDecimal(5) , new BigDecimal(40));
    }

    @Override
    public List<Book> notReleasedBooks(String year) {
        int yearToParse = Integer.parseInt(year);
        LocalDate of = LocalDate.of(yearToParse, 1, 1);
        return bookRepository.findAllByReleaseDateNot(of);

    }

    @Override
    public List<Book> booksReleasedBeforeDate(String year) {
        String[] split = year.split("-");
        int yearToParse = Integer.parseInt(split[2]);
        int monthToParse = Integer.parseInt(split[1]);
        int dayToParse = Integer.parseInt(split[0]);
        LocalDate parse = LocalDate.of(yearToParse , monthToParse , dayToParse);
        return bookRepository.findAllByReleaseDateBefore(parse);
    }

    @Override
    public List<Book> booksSearch(String suffix) {
        return bookRepository.findAllByTitleContaining(suffix);
    }

    @Override
    public List<Book> bookTitlesSearch(String prefix) {
        return bookRepository.findAllByAuthorLastNamePrefix(prefix);
    }

    @Override
    public int countBooks(long length) {
        return bookRepository.countAllByTitleGreaterThan(length);
    }

    @Override
    public ShowingInfo reducedBook(String title) {
        return bookRepository.showGivenInfo(title).get();
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
