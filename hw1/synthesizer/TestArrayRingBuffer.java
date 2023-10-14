package synthesizer;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertTrue(arb.isEmpty());
        arb.enqueue(5);
        assertFalse(arb.isEmpty());
        assertEquals((Integer) 5, arb.peek());
        arb.enqueue(10);
        arb.enqueue(15);
        for(int i : arb) {
            System.out.println(i);
        }
        assertEquals((Integer) 5, arb.dequeue());
        assertEquals((Integer) 10, arb.dequeue());
        assertEquals((Integer) 15, arb.dequeue());
        assertTrue(arb.isEmpty());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
