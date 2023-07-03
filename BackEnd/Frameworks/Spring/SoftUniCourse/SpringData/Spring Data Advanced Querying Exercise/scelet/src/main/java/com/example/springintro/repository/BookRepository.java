package com.example.springintro.repository;

import com.example.springintro.model.entity.DTO.ShowingInfo;
import com.example.springintro.model.entity.Enum.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.Enum.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

//    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);
    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);
    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType type, Integer copies);
    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal price1 , BigDecimal price2);
    List<Book> findAllByReleaseDateNot(LocalDate date);
    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByTitleContaining(String suffix);
    @Query("select b from Book b join b.author a where substring(a.lastName , 1 ,CHAR_LENGTH(:start)) = :start")
    List<Book> findAllByAuthorLastNamePrefix(String start);
    @Query("select count(b) from Book b where char_length(b.title) > :num")
    int countAllByTitleGreaterThan(long num);

    @Query("select new com.example.springintro.model.entity.DTO.ShowingInfo(b.title,b.ageRestriction,b.editionType , b.price) " +
            "from Book b where b.title = :title")
    Optional<ShowingInfo> showGivenInfo(String title);
}
