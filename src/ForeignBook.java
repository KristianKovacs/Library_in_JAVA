public class ForeignBook extends Book{
    private LANGUAGE language;
    public ForeignBook(String name, String author, int numberOfPages, LANGUAGE lang) {
        super(name, author, numberOfPages);
        this.language = lang;
    }

    public LANGUAGE getLanguage() {
        return this.language;
    }

}
