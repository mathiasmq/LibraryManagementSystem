import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VideoGameTest {

    @Test
    void testGetIdentifier() {

        //Arrange
        VideoGame videoGame = new VideoGame("5701234567893", "World of Warcraft", "Blizzard Entertainment", "PC");

        //Act
        String result = videoGame.getIdentifier();

        //Assert
        assertEquals("5701234567893", result);
    }

    @Test
    void testGetTitle() {

        //Arrange
        VideoGame videoGame = new VideoGame("5701234567893", "World of Warcraft", "Blizzard Entertainment", "PC");

        //Act
        String result = videoGame.getTitle();

        //Assert
        assertEquals("World of Warcraft", result);
    }

    @Test
    void testGetCreator() {

        //Arrange
        VideoGame videoGame = new VideoGame("5701234567893", "World of Warcraft", "Blizzard Entertainment", "PC");

        //Act
        String result = videoGame.getCreator();

        //Assert
        assertEquals("Blizzard Entertainment", result);
    }

    @Test
    void testGetPlatform() {

        //Arrange
        VideoGame videoGame = new VideoGame("5701234567893", "World of Warcraft", "Blizzard Entertainment", "PC");

        //Act
        String result = videoGame.getPlatform();

        //Assert
        assertEquals("PC", result);
    }
}
