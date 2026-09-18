public class Book {
// Vi gemmer bogens forfatter, titel, ISBN og ID
    final private String author;
    final private String title;
    final private String isbn;
    final private int id;

// Tilføjer author, title, ISBN og ID til konstruktøren
    public Book(String author, String title, String isbn, int id) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.id = id;
    }

// Getters
// Henter bogens ID
    public int getBookId() {
        return id;
    }

// Retunerer bogens information
    @Override
    public String toString() {
        return author + "; " + title + "; isbn " + isbn + "; id " + id;
    }
}
