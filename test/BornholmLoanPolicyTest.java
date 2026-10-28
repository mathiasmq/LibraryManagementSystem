import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class BornholmLoanPolicyTest {

    @Test
    void testCalculateDueDateAudioBook() {

        //Arrange
        AudioBook audioBook1 = new AudioBook("9781492072505", "Ringenes Herre: Eventyret om ringen", "Tolkien", 1260);
        LocalDate borrowedDate = LocalDate.of(2026, 10, 22);
        LocalDate expectedDueDate = borrowedDate.plusDays(14);
        LoanPolicy bornholmLoanPolicy = new BornholmLoanPolicy();

        //Act
        LocalDate actualDueDate = bornholmLoanPolicy.calculateDueDate(audioBook1, borrowedDate);


        //Arrange
        assertEquals(expectedDueDate, actualDueDate);

    }

    @Test
    void testCalculateDueDateVideoGame() {

        //Arrange
        VideoGame videoGame1 = new VideoGame("5701234567892", "Minecraft", "Mojang Studios", "PC, mobile devices, console");
        LocalDate borrowedDate = LocalDate.of(2026, 10, 22);
        LocalDate expectedDueDate = borrowedDate.plusDays(30);
        LoanPolicy bornholmLoanPolicy = new BornholmLoanPolicy();

        //Act
        LocalDate actualDueDate = bornholmLoanPolicy.calculateDueDate(videoGame1, borrowedDate);


        //Arrange
        assertEquals(expectedDueDate, actualDueDate);

    }
}
