public class ForeignBook extends Book{
    private String language;
    public ForeignBook(String name, String author, int numberOfPages, String lang) {
        super(name, author, numberOfPages);
        this.language = lang;
    }

    public String getLanguage() {
        return language;
    }

}
