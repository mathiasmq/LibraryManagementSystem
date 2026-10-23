public class Book extends Resource {

    // Gemmer antallet af sider i bogen
    private int pages;

    // Konstruktør der gemmer bogens oplysninger
    public Book(String identifier, String title, String creator, int pages) {
        super(identifier, title, creator);
        this.pages = pages;
    }

    // Getters
    // Returnerer antallet af sider
    public int getPages() {
        return pages;
    }

    // Returnerer bogens information som tekst
    @Override
    public String toString() {
        return "ISBN: " + getIdentifier()
                + "\nTitle: " + getTitle()
                + "\nAuthor: " + getCreator()
                + "\nPages: " + pages;
    }
}