package com.example.books.repos;

import com.example.books.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("select a from Author a order by RAND() limit 1")
    Author getRandomAuthor();

    Optional<Author> findByName(String name);
}
