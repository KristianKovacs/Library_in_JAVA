public class ScientificBook extends Book {

    private String field;

    public ScientificBook(String name, String author, int numberOfPages, String field) {
        super(name, author, numberOfPages);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    @Override
    public String toString() {
        return this.field;
    }
}
