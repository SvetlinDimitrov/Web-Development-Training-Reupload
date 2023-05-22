package com.example.springintroexecise.repository;

import com.example.springintroexecise.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepo  extends JpaRepository<Book , Long> {
    List<Book> findBooksByReleaseDateAfter(LocalDate date);
    List<Book> findBookByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitleAsc(String firstName , String lastName);
}
