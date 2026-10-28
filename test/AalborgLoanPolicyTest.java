

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AalborgLoanPolicyTest {

    private AalborgLoanPolicy policy;
    private Member member;
    private LocalDate borrowedDate;
    private LocalDate dueDate;

    @BeforeEach
    void setUp() {
        policy = new AalborgLoanPolicy();
        member = new Member("Test Member", 1);
        borrowedDate = LocalDate.of(2026, 1, 1);
        dueDate = LocalDate.of(2026, 1, 31);
    }

    private Movie createMovie(String identifier) {
        return new Movie(
                identifier,
                "Test Movie",
                "Test Creator",
                120,
                "Test Director"
        );
    }

    private VideoGame createVideoGame(String identifier) {
        return new VideoGame(
                identifier,
                "Test Game",
                "Test Creator",
                "PlayStation"
        );
    }

    private Loan createLoan(Resource resource) {
        return new Loan(resource, member, borrowedDate, dueDate);
    }

    // Test 1: A member with no loans can borrow a movie
    @Test
    void LoanTrueNoLoans() {
        ArrayList<Loan> loans = new ArrayList<>();
        Movie movie = createMovie("M001");

        boolean result = policy.canLoan(movie, loans, member);

        assertTrue(result);
    }

    // Test 2: A member with two loans can borrow another movie
    @Test
    void LoanTrueTwoLoans() {
        ArrayList<Loan> loans = new ArrayList<>();
        loans.add(createLoan(createMovie("M001")));
        loans.add(createLoan(createMovie("M002")));

        Movie requestedMovie = createMovie("M003");

        boolean result = policy.canLoan(requestedMovie, loans, member);

        assertTrue(result);
    }

    // Test 3: A member with three loans cannot borrow another movie
    @Test
    void LoanFalseThreeLoans() {
        ArrayList<Loan> loans = new ArrayList<>();
        loans.add(createLoan(createMovie("M001")));
        loans.add(createLoan(createMovie("M002")));
        loans.add(createLoan(createMovie("M003")));

        Movie requestedMovie = createMovie("M004");

        boolean result = policy.canLoan(requestedMovie, loans, member);

        assertFalse(result);
    }

    // Test 4: A member with three loans cannot borrow another video game
    @Test
    void LoanReturnsFalseVideoGame() {
        ArrayList<Loan> loans = new ArrayList<>();
        loans.add(createLoan(createVideoGame("G001")));
        loans.add(createLoan(createVideoGame("G002")));
        loans.add(createLoan(createVideoGame("G003")));

        VideoGame requestedGame = createVideoGame("G004");

        boolean result = policy.canLoan(requestedGame, loans, member);

        assertFalse(result);
    }

    // Test 5: due date is 30 days after the borrowed date
    @Test
    void calculateDueDateReturnsDate30DaysLater() {
        LocalDate result =
                policy.calculateDueDate(createMovie("M001"), borrowedDate);

        assertEquals(dueDate, result);
    }

}