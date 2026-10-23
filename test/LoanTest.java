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
        Loan loan = new Loan(videoGame, member, borrowedDate);
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
//        Member memberFail = new Member("Lars Hansen", 444);
        LocalDate borrowedDate = LocalDate.of(2026, 10, 22);
        Loan loan = new Loan(videoGame, member, borrowedDate);
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
        Loan loan = new Loan(videoGame, member, borrowedDate);
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
        Loan loan = new Loan(videoGame, member, borrowedDate);
        //Act
        LocalDate dueDate = loan.getDueDate();
        //Arrange
        assertEquals(LocalDate.of(2026, 11, 5), dueDate);
        //Hvis datoen f.eks er 2025, 11, 10, så vil testen fejle.


    }

}
