import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AudioBookTest {

    @Test
    void testGetCreator() {

        //Arrange
        AudioBook audioBook = new AudioBook("9781492072504", "Harry Potter: De vises sten", "J.K. Rowling", 600);

        //Act
        String result = audioBook.getCreator();

        //Assert
        assertEquals("J.K. Rowling", result);
    }
    @Test
    void testGetTitle() {

        //Arrange
        AudioBook audioBook = new AudioBook("9781492072504", "Harry Potter: De vises sten", "J.K. Rowling", 600);

        //Act
        String result = audioBook.getTitle();

        //Assert
        assertEquals("Harry Potter: De vises sten", result);
    }


    @Test
    void testGetIdentifier() {

        //Arrange
        AudioBook audioBook = new AudioBook("9781492072504", "Harry Potter: De vises sten", "J.K. Rowling", 600);

        //Act
        String result = audioBook.getIdentifier();

        //Assert
        assertEquals("9781492072504", result);
    }


    @Test
    void testGetAudioBookLength() {

        //Arrange
        AudioBook audioBook = new AudioBook("9781492072504", "Harry Potter: De vises sten", "J.K. Rowling", 600);

        //Act
        int result = audioBook.getAudioBookLength();

        //Assert
        assertEquals(600, result);
    }


}