import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private LoanPolicy loanPolicy;
    private Library library;
    private Book book;
    private Member member;



    @BeforeEach
    void setup(){
        loanPolicy = new StandardLoanPolicy();
        library = new Library(loanPolicy);
        book = new Book("9781492072508", "Think Java", "Allan B. Downey", 150);
        member = new Member("Thorkild Hansen", 111);
        library.addMember(member);
        library.addResource(book);




    }


    @Test
    void testLoanWithUnknownMember() {
        //Act
        LoanResult result = library.loan("Think Java", 555);

        //Assert
        assertEquals(LoanResult.MEMBER_NOT_FOUND, result);
    }


    @Test
    void testLoanWithUnknownResource(){

        //Act
        LoanResult result = library.loan("Hej", 111);

        //Assert
        assertEquals(LoanResult.RESOURCE_NOT_FOUND, result);
    }

    @Test
    void testLoanSucces(){

        // Act
        LoanResult result = library.loan("Think Java", 111);
        // Assert
        assertEquals(LoanResult.SUCCESS, result);
    }


    @Test
    void testAlreadyLoaned(){
        Member member1 = new Member("Lise Andersen", 222);
        library.addMember(member1);

     
        LoanResult result1 = library.loan("Think Java", 111);
        assertEquals(LoanResult.SUCCESS, result1);

        LoanResult result = library.loan("Think Java", 222);
        assertEquals(LoanResult.ALREADY_LOANED, result);
    }

    @Test
    void testResourceLoanAfterReturn (){
        //Act
        library.loan("Think Java", 111);
        library.returnLoan("Think Java");

        LoanResult loanResult = library.loan("Think Java", 111);

        //Assert
        assertEquals(LoanResult.SUCCESS, loanResult);


    }

    @Test
    void testLoanCanReturnIfActive ()   {
        boolean result = library.returnLoan("Think Java");
        assertFalse(result);
    }




}
