package JavaAdvance.Iterators_and_Comparators_Lab.Book_01;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> author;

    public Book(String title, int year, String...author) {
        this.title = title;
        this.year = year;
        this.author = Arrays.asList(author);
    }

    @Override
    public String toString() {
        return String.format("%s , %d: %s%n",title,year , String.join(", ",author));
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }
}
