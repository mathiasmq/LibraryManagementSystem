import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    void testBook1() {

        // Arrange
        Book book1 = new Book("9781492072508", "Think Java", "Allan B. Downey", 150);

        // Act
        String identifier = book1.getIdentifier();
        String title = book1.getTitle();
        String creator = book1.getCreator();
        int pages = book1.getPages();

        // Assert
        assertEquals("9781492072508", identifier);
        assertEquals("Think Java", title);
        assertEquals("Allan B. Downey", creator);
        assertEquals(150, pages);
    }

    @Test
    void testBook2() {

        // Arrange
        Book book2 = new Book("9788763851664", "Omrids", "Rachel Cusk", 200);

        // Act
        String identifier = book2.getIdentifier();
        String title = book2.getTitle();
        String creator = book2.getCreator();
        int pages = book2.getPages();

        //
        assertEquals("9788763851664", identifier);
        assertEquals("Omrids", title);
        assertEquals("Rachel Cusk", creator);
        assertEquals(200, pages);
    }

    @Test
    void testBook3() {

        // Arrange
        Book book3 = new Book("9780062316097", "Sapiens", "Yuval Noah Harari", 400);

        // Act
        String identifier = book3.getIdentifier();
        String title = book3.getTitle();
        String creator = book3.getCreator();
        int pages = book3.getPages();

        // Assert
        assertEquals("9780062316097", identifier);
        assertEquals("Sapiens", title);
        assertEquals("Yuval Noah Harari", creator);
        assertEquals(400, pages);
    }
}