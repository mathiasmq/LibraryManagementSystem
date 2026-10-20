public class Book extends Resource {
// Vi gemmer bogens forfatter, titel, ISBN og ID
//    final private String author;
//    final private String title;
//    final private String isbn;
    private int pages;
    final private int id;

// Tilføjer author, title, ISBN og ID til konstruktøren
    public Book(String identifier, String title, String creator, int id, int pages) {
//        this.author = author;
//        this.title = title;
//        this.isbn = isbn;
        super (identifier, title, creator);
        this.id = id;
        this.pages = pages;
    }

// Getters
// Henter bogens ID
    public int getBookId() {
        return id;
    }

//// Retunerer bogens information
//    @Override
//    public String toString() {
//        return author + "; " + title + "; isbn " + isbn + "; id " + id;
//    }
}
