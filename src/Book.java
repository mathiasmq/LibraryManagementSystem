public class Book extends Resource {
// Vi gemmer bogens forfatter, titel, ISBN og ID
    private int pages;
    final private int id;

// Tilføjer author, title, ISBN og ID til konstruktøren
    public Book(String identifier, String title, String creator, int id, int pages) {
        super(identifier, title, creator);
        this.id = id;
        this.pages = pages;
    }

// Getters
// Henter bogens ID
    public int getBookId() {
        return id;
    }

// Retunerer bogens information
    @Override
    public String toString() {
        return "ISBN: " + getIdentifier() + "\nTitle: " + getTitle() + "\nAuthor: " + getCreator() + "\nID: " + id + "\nPages: " + pages;
    }
}
