import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void testisSameNumber() {
        Integer a = 128;
        Integer b = 128;
        String Message = "";
        assertTrue(Message, Flik.isSameNumber(a, b));
        System.out.println(Message);
    }

    @Test
    public void testHorribleSteve() {

    }
}
