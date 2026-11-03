import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibrarySaverTest {

//    @Test
//    void testSaveMembers() throws IOException {
//        //Arrange
//        List<Member> members = new ArrayList<>(List.of(
//                new Member("Thorkild Hansen", 111),
//                new Member("Lise Andersen", 222),
//                new Member("Rojin Atci", 333)));
//
//        LibrarySaver librarySaver = new LibrarySaver();
//
//        //Act
//        librarySaver.saveMembers(members, "test-members.csv");
//
//        //Assert
//        String expected = """
//
//                """;
//        String actual = Files.readString(Path.of("test-members.csv"));
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testSaveBooks() throws IOException {
//        //Arrange
//        List<Book> books = new ArrayList<>(List.of(
//                new Book("9781492072508", "Think Java", "Allan B. Downey", 150),
//                new Book("9788763851664", "Omrids", "Rachel Cusk", 200),
//                new Book("9780062316097", "Sapiens", "Yuval Noah Harari", 400)));
//
//        LibrarySaver librarySaver = new LibrarySaver();
//
//        //Act
//        librarySaver.saveBooks(books, "test-books.csv");
//
//        //Assert
//        String expected = """
//
//                """;
//        String actual = Files.readString(Path.of("test-books.csv"));
//        assertEquals(expected, actual);
//
//    }
//
//    @Test
//    void testSaveLoans() throws IOException {
//        //Arrange
//        List<Loan> loans = new ArrayList<>(List.of(
//                new Loan(new Book("9781492072508", "Think Java", "Allan B. Downey", 150), new Member("Thorkild Hansen", 111), LocalDate.of(2026, 11, 3), LocalDate.of(2026, 12, 3))));
//
//        LibrarySaver librarySaver = new LibrarySaver();
//
//        //Act
//        librarySaver.saveLoans(loans, "test-loans.csv");
//
//        //Assert
//        String expected = """
//
//                """;
//        String actual = Files.readString(Path.of("test-loans.csv"));
//        assertEquals(expected, actual);
//    }
}
