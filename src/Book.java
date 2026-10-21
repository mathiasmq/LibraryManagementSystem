public class Book extends Resource {
// Vi gemmer bogens forfatter, titel, ISBN og ID
    private int pages;

// Tilføjer author, title, ISBN og ID til konstruktøren
    public Book(String identifier, String title, String creator, int pages) {
        super(identifier, title, creator);
        this.pages = pages;
    }


// Retunerer bogens information
    @Override
    public String toString() {
        return "ISBN: " + getIdentifier() + "\nTitle: " + getTitle() + "\nAuthor: " + getCreator() + "\nPages: " + pages;
    }
}
