
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    void testGetName() {
        // Arrange
        Movie movie = new Movie(
                "123456789",
                "Inception",
                "Warner Bros.",
                148,
                "Christopher Nolan"
        );

        // Act
        String result = movie.toString();

        // Assert
        assertEquals(
                "EAN: 123456789\n" +
                        "Title: Inception\n" +
                        "Production: Warner Bros.\n" +
                        "Length: 148 minutes\n" +
                        "Director: Christopher Nolan",
                result
        );
    }

    @Test
    void testToStringContainsTitle() {
        // Arrange
        Movie movie = new Movie(
                "123456789",
                "Inception",
                "Warner Bros.",
                148,
                "Christopher Nolan"
        );

        // Act
        String result = movie.toString();

        // Assert
        assertTrue(result.contains("Title: Inception"));
    }

    @Test
    void testToStringContainsMovieLength() {
        // Arrange
        Movie movie = new Movie(
                "123456789",
                "Inception",
                "Warner Bros.",
                148,
                "Christopher Nolan"
        );

        // Act
        String result = movie.toString();

        // Assert
        assertTrue(result.contains("Length: 148 minutes"));
    }

    @Test
    void testToStringContainsDirector() {
        // Arrange
        Movie movie = new Movie(
                "123456789",
                "Inception",
                "Warner Bros.",
                148,
                "Christopher Nolan"
        );

        // Act
        String result = movie.toString();

        // Assert
        assertTrue(result.contains("Director: Christopher Nolan"));
    }

    @Test
    void testToStringContainsCreator() {
        // Arrange
        Movie movie = new Movie(
                "123456789",
                "Inception",
                "Warner Bros.",
                148,
                "Christopher Nolan"
        );

        // Act
        String result = movie.toString();

        // Assert
        assertTrue(result.contains("Length: 148 minutes"));
    }
}