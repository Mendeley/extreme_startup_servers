import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {
    @Test
    public void testName() throws Exception {
        assertEquals(1,Fibonacci.fibonacci(1));
        assertEquals(1,Fibonacci.fibonacci(2));
        assertEquals(2,Fibonacci.fibonacci(3));
        assertEquals(3,Fibonacci.fibonacci(4));
        assertEquals(5,Fibonacci.fibonacci(5));
        assertEquals(8,Fibonacci.fibonacci(6));
        assertEquals(13,Fibonacci.fibonacci(7));

    }
}