package com.example.springintroexecise.repository;

import com.example.springintroexecise.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    List<Author> findAuthorsByBooks_ReleaseDateBefore(LocalDate date);

}
