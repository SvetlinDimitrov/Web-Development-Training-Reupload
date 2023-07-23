package com.example.books.controller;

import com.example.books.dtos.BookView;
import com.example.books.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/book")
public class BookController {
    private final BookService service;

    public BookController(BookService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<BookView>> getAllBooks(){
        List<BookView> allBooks = service.getAllBooks();
        return ResponseEntity.ok(allBooks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookView> getAllBooks(@PathVariable(value = "id") Long bookId){
        return service.getBookById(bookId)
                .map(b->new ResponseEntity<>(b,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BookView> delete(@PathVariable(value = "id") Long bookId){
        return service.deleteBookById(bookId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<BookView> createBook(@RequestBody BookView bookView){
        service.saveBook(bookView);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
