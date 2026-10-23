import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MemberTest {

    @Test
    void testGetName() {

        //Arrange
        Member member = new Member("Thorkild Hansen", 111);

        //Act
        String result = member.getName();

        //Assert
        assertEquals("Thorkild Hansen", result);
    }

    @Test
    void testGetMemberId() {

        //Arrange
        Member member = new Member("Thorkild Hansen", 111);

        //Act
        int result = member.getMemberId();

        //Assert
        assertEquals(111, result);
    }
}

