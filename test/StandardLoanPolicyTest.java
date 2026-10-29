import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StandardLoanPolicyTest {



    // Tester at standardreglen altid siger ja til et lån
    @Test
    void testCanLoanAlwaysTrue() {
        //Arrange
        StandardLoanPolicy policy = new StandardLoanPolicy();
        Book book = new Book("9781492072508", "Think Java", "Allan B. Downey", 150);
        Member member = new Member("Thorkild Hansen", 111);
        List<Loan> loans = new ArrayList<>();

        //Act
        boolean result = policy.canLoan(book, loans, member);

        //Assert
        assertTrue(result);

    }


    // Tester at standardreglen giver en afleveringsdato 30 dage efter lånedatoen
    @Test
    void testCalculateDueDateIs30Days() {
        //Arrange
        StandardLoanPolicy policy = new StandardLoanPolicy();
        Book book = new Book("9781492072508", "Think Java", "Allan B. Downey", 150);
        // // Bruger en fast lånedato, så testen giver samme resultat hver dag
        LocalDate borrowedDate = LocalDate.of(2026, 10, 28);

        //Act
        LocalDate result = policy.calculateDueDate(book, borrowedDate);

        //Assert
        assertEquals(LocalDate.of(2026, 11, 27), result);
    }
}













