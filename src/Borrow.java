import java.util.Date;

public class Borrow {
    private Book book;
    private Customer customer;
    private Date dateOfBorrowing;
    private Date dateOfReturn;

    public Borrow(Book book, Customer customer, Date dateOfBorrowing, Date dateOfReturn) {
        this.book = book;
        this.customer = customer;
        this.dateOfBorrowing = dateOfBorrowing;
        this.dateOfReturn = dateOfReturn;
    }

    public Book getBook() {
        return book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getDateOfBorrowing() {
        return dateOfBorrowing;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }
}
