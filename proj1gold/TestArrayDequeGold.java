import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testStudentArray() {

        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();
        String message = "";

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                sad2.addLast(i);
                message += "addList(" + i + ")\n";
            } else {
                sad1.addFirst(i);
                sad2.addFirst(i);
                message += "addFirst(" + i + ")\n";
            }
        }

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                message += "removeFirst()\n";
                assertEquals(message, sad2.removeFirst(),sad1.removeFirst());
            } else {
                message += "removeLast()\n";
                assertEquals(message, sad2.removeLast(),sad1.removeLast());
            }
        }

    }
}
