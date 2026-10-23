import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    void testLoanWithUnknownMember() {
        //Arrange
        Library library = new Library();
        Book book = new Book("9781492072508", "Think Java", "Allan B. Downey", 150);
        Member member = new Member("Thorkild Hansen", 111);

        //Act
        LoanResult result = library.loan("Think Java", 555);

        //Assert
        assertEquals(LoanResult.MEMBER_NOT_FOUND, result);
    }






}
