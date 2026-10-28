import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoanTest {

    @Test
    void testGetResource() {

        //Arrange
        VideoGame videoGame = new VideoGame("5701234567893", "World of Warcraft", "Blizzard Entertainement", "PC");
        Member member = new Member("Thorkild Hansen", 111);
        LocalDate borrowedDate = LocalDate.of(2026, 10, 22);
        LocalDate dueDate = borrowedDate.plusDays(30);
        Loan loan = new Loan(videoGame, member, borrowedDate, dueDate);

        //Act
        Resource resource = loan.getResource();

        //Assert
        assertEquals(videoGame, resource);
    }

    @Test
    void testGetMember() {

        //Arrange
        VideoGame videoGame = new VideoGame("5701234567893", "World of Warcraft", "Blizzard Entertainement", "PC");
        Member member = new Member("Thorkild Hansen", 111);
        Member memberFail = new Member("Lars Hansen", 444);
        LocalDate borrowedDate = LocalDate.of(2026, 10, 22);
        LocalDate dueDate = borrowedDate.plusDays(30);
        Loan loan = new Loan(videoGame, member, borrowedDate, dueDate);

        //Act
        Member member1 = loan.getMember();

        //Assert
        assertEquals(member, member1);
    }

    @Test
    void testGetBorrowedDate() {

        //Arrange
        VideoGame videoGame = new VideoGame("5701234567893", "World of Warcraft", "Blizzard Entertainement", "PC");
        Member member = new Member("Thorkild Hansen", 111);
        LocalDate borrowedDate = LocalDate.of(2026, 10, 22);
        LocalDate dueDate = borrowedDate.plusDays(30);
        Loan loan = new Loan(videoGame, member, borrowedDate, dueDate);

        //Act
        LocalDate date = loan.getBorrowedDate();

        //Assert
        assertEquals(borrowedDate, date);

    }

    @Test
    void testGetDueDate() {

        //Arrange
        VideoGame videoGame = new VideoGame("5701234567893", "World of Warcraft", "Blizzard Entertainement", "PC");
        Member member = new Member("Thorkild Hansen", 111);
        LocalDate borrowedDate = LocalDate.of(2026, 10, 22);
        LocalDate expectedDueDate = borrowedDate.plusDays(30);
        Loan loan = new Loan(videoGame, member, borrowedDate, expectedDueDate );

        //Act
        LocalDate actualDueDate = loan.getDueDate();

        //Arrange
        assertEquals(expectedDueDate, actualDueDate);
        //Hvis datoen f.eks er 2025, 11, 10, så vil testen fejle.


    }
}
