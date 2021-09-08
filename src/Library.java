import javax.xml.crypto.Data;
import java.sql.SQLOutput;
import java.util.*;

public class Library {

    /**
     *  clear CLI
     */
    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.redirectInput(ProcessBuilder.Redirect.INHERIT).start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.redirectInput(ProcessBuilder.Redirect.INHERIT).start();
                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * write out list of available books in library
     * @param books list of available books in library
     *
     */
    public static void ListingOfBooks(List<Book> books) {

        int count = 1;
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Current List of books in library:");
        for (Book book : books) {
            System.out.print(count + ".");
            System.out.println(book);
            count++;
        }
        System.out.println("---------------------------------");
        System.out.println();

    }

    /**
     * Search for a book in library
     * @param bookName name of the book
     * @param books local DB of books in library
     * @return the book
     */
    public static Book searchForBook(String bookName, List<Book> books){
        for (Book book : books) {
            if(book.getNameOfTheBook() == bookName) {
                return book;
            }
        }
        return null;
    }

    /**
     * Search for customer in libarary system
     * @param customerName name of the customer (first or last)
     * @param customers local DB of customers in library
     * @return the customer
     */
    public static Customer searchForCustomer(String customerName, Set<Customer> customers){
        for (Customer customer : customers) {
            if (customer.getFirstName() == customerName || customer.getLastName() == customerName){
                return customer;
            }
        }
        return null;
    }

    /**
     * write out listing of all customers in library
     * @param array list of customers in library
     */
    public static void ListingOfCustomers(Set<Customer> array) {
        System.out.println("Listing of customers: ");
        for (Customer customer : array) {
            System.out.println(customer);
        }
    }

    /**
     *  Comb out reservation system
     * @param borrows list of all borrowed books
     * @param bookName name of a book
     * @return true if book called 'bookName' found
     */
    public static boolean CombOutReservations(Set<Borrow> borrows, String bookName) {
        for (Borrow b : borrows) {
            if (b.getBook().getNameOfTheBook() == bookName) {
                return true;
            }
        }
        return false;
    }

    public static void ListingOfNotReservedBooks(Set<Borrow> borrows) {
        System.out.println();
        System.out.println("Listing of available books:");
        System.out.println();
        for (Borrow borrow : borrows) {
            if(borrow.getDateOfBorrowing() == null) {
                System.out.println(borrow.getBook().getNameOfTheBook());
            }

        }
    }

    /**
     * Remove book from library (element from array)
     * @param array list of all books in library
     * @param element book to remove
     */
    public static void RemoveBookFromLibrary(List<Book> array, String element) {
        for (Book book : array) {
            if(book.getNameOfTheBook() == element) {
                array.remove(book);
            }
        }
    }

    /**
     * ************************************
     *  M   A   I   N
     * ************************************
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = 0;

        //////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        // array lists defined:
        List<Book> books = new ArrayList<>();
        Set<Customer> customers = new HashSet<Customer>();
        Set<Borrow> borrows = new HashSet<Borrow>();
        //////////////////////////////////////////////////////
        //////////////////////////////////////////////////////

        top: while( choice!= 4) {

            /* top menu */
            System.out.println();
            System.out.println("> fake library system 0.001");
            System.out.println();
            System.out.println("> 1. Books");
            System.out.println("> 2. Reservation");
            System.out.println("> 3. Customers");
            System.out.println("> 4. Exit");
            System.out.println();
            System.out.print("Choose your option: ");
            choice = input.nextInt();

            switch(choice) {
                case 1:
                    int opt;
                    /* book menu*/
                    System.out.println();
                    System.out.println("> 1. Add a new book to Library");
                    System.out.println("> 2. Remove a book from Library");
                    System.out.println("> 3. List all books in Library");
                    System.out.println("> 4. Go level up");
                    System.out.println();
                    System.out.print("Choose your option: ");
                    opt = input.nextInt();

                    switch(opt) {
                        case 1:
                            String scientific = "", language = "";

                            System.out.println("Choose book type (standard=1, scientific=2, foreign=3): ");
                            int bookType = input.nextInt();
                            if (bookType == 2) {
                                System.out.println("What kind of scientific book are you planning to add? : ");
                                scientific = input.next();
                            }
                            if(bookType == 3) {
                                System.out.println("Im what language is in the foreign book written?");
                                language = input.next();
                            }
                            System.out.print("Choose title/name for the book: ");
                            String name = input.next();

                            System.out.print("Choose author of the book: ");
                            String author = input.next();/**/

                            System.out.print("Choose page numbers: ");
                            int pageNumber = input.nextInt();

                            if(bookType == 1) {
                                Book book = new Book(name,author, pageNumber);
                                books.add(book);
                            } else if(bookType == 2) {
                                Book book = new ScientificBook(name,author,pageNumber,scientific);
                                books.add(book);
                            } else if(bookType == 3) {
                                Book book = new ForeignBook(name,author,pageNumber,language);
                                books.add(book);
                            }
                            break;

                        case 2:
                            System.out.println("Choose name of the book to be removed from list: ");
                            String bookToRemove = input.next();
                            RemoveBookFromLibrary(books,bookToRemove);
                            break;
                        case 3:
                            ListingOfBooks(books);
                            break;


                    }
                    break;

                case 2:
                    /* reservation menu */
                    reservation: System.out.println();
                    System.out.println("Reservation menu");
                    System.out.println();
                    System.out.println("> 1. Preserve a book");
                    System.out.println("> 2. Listing of all available books");
                    System.out.println("> 3. Go level up");
                    System.out.println();
                    System.out.println();
                    System.out.print("Choose your option: ");
                    opt = input.nextInt();
                    if(opt == 1){
                        String bookName;
                        System.out.print("Enter book name: ");
                        bookName = input.next();

                        System.out.println("Searching ...");
                        if(CombOutReservations(borrows,bookName)) {
                            System.out.println("Sorry this book is borrowed right now ... ");
                        } else {
                            System.out.println("You can borrow it, just  need some information from you");
                            System.out.print("Enter your(customer) name: ");
                            String customerName = input.next();

                            Customer customer = searchForCustomer(customerName, customers);
                            Book book = searchForBook(bookName, books);
                            Borrow borrow = new Borrow(book,customer,new Date(), null);

                            System.out.println(String.format("The book called %s has been borrowed by %s", book.getNameOfTheBook(), customer));

                        }

                    }else if(opt == 2){


                    }else if (opt == 3) {

                    }

                    break;
                case 3:
                    /* customer menu */
                    System.out.println();
                    System.out.println("> 1. Add a new customer to system");
                    System.out.println("> 2. Remove a customer from system");
                    System.out.println("> 3. Listing all customers");
                    System.out.println("> 4. Go level up");
                    System.out.println();
                    System.out.print("Choose your option: ");
                    opt = input.nextInt();

                    if(opt == 1) {
                        System.out.print("Enter first name: ");
                        String fName = input.next();

                        System.out.print("Enter last name:");
                        String lName = input.next();

                        System.out.print("Enter street name: ");
                        String sName = input.next();

                        System.out.print("Enter street number: ");
                        String sNumber = input.next();

                        System.out.print("Enter city: ");
                        String city = input.next();

                        System.out.print("Enter country: ");
                        String country = input.next();

                        Address address = new Address(sName,sNumber,city,country);
                        Customer customer = new Customer(fName,lName, address);

                        customers.add(customer);

                    }
                    if (opt == 3) {
                        ListingOfCustomers(customers);
                    }
                    break;
                case 4:
                    break top;

            }

        }

        }








}
