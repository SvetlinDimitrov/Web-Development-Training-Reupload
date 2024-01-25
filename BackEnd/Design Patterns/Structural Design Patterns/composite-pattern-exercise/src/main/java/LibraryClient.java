public class LibraryClient {

  public static void main(String[] args) {

    Books nonfictionBook = new NonfictionBooks("A Brief History of Time");
    Books fictionBookOne = new FictionBooks("Hamlet", true);
    Books fictionBookTwo = new FictionBooks("The Great Gatsby", false);

    BooksCollection bookCollection = new BooksCollection();
    bookCollection.addBook(nonfictionBook);
    bookCollection.addBook(fictionBookOne);
    bookCollection.addBook(fictionBookTwo);

    checkout(nonfictionBook);
    checkout(fictionBookOne);
    checkout(bookCollection);

    returnBook(nonfictionBook);
    returnBook(fictionBookOne);
    returnBook(bookCollection);

  }

  public static void checkout(Books book) {
    book.checkout();
  }
  public static void returnBook(Books book) {book.returnBook();}

}
