public class Book {
    private String nameOfTheBook;
    private String nameOfTheAuthor;
    private int numberOfPages;

    public Book(String nameOfTheBook, String nameOfTheAuthor, int numberOfPages) {
        this.nameOfTheBook = nameOfTheBook;
        this.nameOfTheAuthor = nameOfTheAuthor;
        this.numberOfPages = numberOfPages;

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("A book called " + this.nameOfTheBook + " from " + this.nameOfTheAuthor + " has been created");
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    public String getNameOfTheBook() {
        return nameOfTheBook;
    }

    public String getNameOfTheAuthor() {
        return nameOfTheAuthor;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return this.nameOfTheAuthor + ":" + this.nameOfTheBook;
    }
}


