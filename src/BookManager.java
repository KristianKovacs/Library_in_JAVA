import java.util.ArrayList;
import java.util.List;

public class BookManager{

    protected List<Book> books;

    public BookManager() {
        System.out.println("Create new book manager .............");
        this.books = new ArrayList<Book>();
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public void remove(Book book) {
        this.books.remove(book);
    }
}
