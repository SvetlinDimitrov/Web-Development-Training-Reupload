import java.util.ArrayList;

public class BooksCollection implements Books {

  private final ArrayList<Books> nonfictionBooks = new ArrayList<>();

  public void addBook(Books nonfictionBook) {
    nonfictionBooks.add(nonfictionBook);
  }
  public void checkout() {
    nonfictionBooks.forEach(Books::checkout);
  }

  public void returnBook() {
    nonfictionBooks.forEach(Books::returnBook);
  }


}
