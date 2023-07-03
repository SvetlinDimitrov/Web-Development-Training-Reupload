package com.example.springintroexecise.services;

import com.example.springintroexecise.entity.Author;
import com.example.springintroexecise.entity.Book;
import com.example.springintroexecise.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class AuthorServiceImp  implements AuthorService{
    private AuthorRepo authorRepo;
    private static final String AUTHORS_FILE_NAME = "src\\main\\resources\\files\\authors.txt";

    @Autowired
    public AuthorServiceImp(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public void registerAuthors() throws IOException {
        if(authorRepo.findAll().isEmpty()){
            List<Author> authors = Files.readAllLines(Path.of(AUTHORS_FILE_NAME))
                    .stream()
                    .map(row -> new Author(row.split(" ")[0] , row.split(" ")[1]))
                    .toList();
            authorRepo.saveAll(authors);
        }
    }

    @Override
    public Author getRandomAuthor() {
        List<Author> allAuthors = authorRepo.findAll();
        if(allAuthors.isEmpty()){
            throw new RuntimeException("No authors");
        }
        Random random = new Random();
        int randomAuthorIndex = random.nextInt(0, allAuthors.size());
        return allAuthors.get(randomAuthorIndex);
    }

    @Override
    public List<String> authorsWhoHaveAtLeastOneBookBefore1990() {
        return authorRepo.findAuthorsByBooks_ReleaseDateBefore(LocalDate.of(1990 , 1 ,1))
                .stream()
                .map(a-> String.format("%s %s" , a.getFirstName() , a.getLastName()))
                .toList();

    }

    @Override
    public List<String> allAuthorsOrderByBookCount() {
       return authorRepo.findAll().stream()
                .sorted((f,s) -> s.getBooks().size() - f.getBooks().size())
                .map(e-> String.format("%s %s %d" , e.getFirstName(),e.getLastName() , e.getBooks().size()))
                .toList();
    }

}
