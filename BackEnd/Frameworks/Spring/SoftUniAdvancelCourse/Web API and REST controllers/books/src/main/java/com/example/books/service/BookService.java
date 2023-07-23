package com.example.books.service;


import com.example.books.dtos.BookView;
import com.example.books.entity.Author;
import com.example.books.repos.AuthorRepository;
import com.example.books.repos.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.example.books.entity.Book;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public void seedBooks() {
        if (bookRepository.count() == 0) {
            bookRepository.saveAll(List.of(
                            new Book("Под Игото", randomIsbn(), authorRepository.getRandomAuthor()),
                            new Book("Розови Листа", randomIsbn(), authorRepository.getRandomAuthor()),
                            new Book("Навън е топло", randomIsbn(), authorRepository.getRandomAuthor()),
                            new Book("Искам сладолед", randomIsbn(), authorRepository.getRandomAuthor()),
                            new Book("Да бъдеш или да остарееш", randomIsbn(), authorRepository.getRandomAuthor()),
                            new Book("Димчо на терасата", randomIsbn(), authorRepository.getRandomAuthor()),
                            new Book("Лятото е толо", randomIsbn(), authorRepository.getRandomAuthor()),
                            new Book("Остаряване или подмладяване", randomIsbn(), authorRepository.getRandomAuthor()),
                            new Book("Кана с вода", randomIsbn(), authorRepository.getRandomAuthor()),
                            new Book("Джон Лук1", randomIsbn(), authorRepository.getRandomAuthor()),
                            new Book("СпидерВоман", randomIsbn(), authorRepository.getRandomAuthor()),
                            new Book("АтакаДоНебето", randomIsbn(), authorRepository.getRandomAuthor()),
                            new Book("Атрактика е топла вече", randomIsbn(), authorRepository.getRandomAuthor()),
                            new Book("ТопШоп", randomIsbn(), authorRepository.getRandomAuthor())
                    )
            );
        }
    }

    public List<BookView> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::toBookView)
                .toList();
    }

    public Optional<BookView> getBookById(Long id) {
        Optional<Book> byId = bookRepository.findById(id);
        return byId.map(this::toBookView);
    }

    private String randomIsbn() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            if (builder.length() == 1 || builder.length() == 6 || builder.length() == 11) {
                builder.append("-");
            }
            builder.append(random.nextInt(0, 10));
        }
        return builder.toString();
    }

    private BookView toBookView(Book book) {
        return new BookView(book.getId() , book.getTitle(), book.getIsbn(), book.getAuthor().getName());
    }


    public boolean deleteBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .map(b -> {
                    bookRepository.deleteById(bookId);
                    return true;
                })
                .orElse(false);
    }

    public void saveBook(BookView bookView) {
        if (authorRepository.findByName(bookView.getAuthor()).isEmpty()) {
            authorRepository.save(new Author(bookView.getAuthor()));
        }
        bookRepository.save(new Book(bookView.getTitle(),
                bookView.getIsbn(),
                authorRepository.findByName(bookView.getAuthor()).orElseThrow()));
    }
}
