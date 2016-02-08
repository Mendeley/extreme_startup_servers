import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExtremeStartupTest {

    private final ExtremeStartup server = new ExtremeStartup();

    @Test
    public void should_accept_missing_input() {
        assertEquals(server.answer(null), "team name");
    }

    @Test
    public void should_add_numbers() {
        assertEquals(server.answer("what is the sum of 14 and 4"), "18");
    }

    @Test
    public void should_max_numbers(){
        assertEquals("593",server.answer("which of the following numbers is the largest: 65, 593, 142, 85"));
    }

    @Test
    public void should_primecheck_numbers(){
        assertEquals("593",server.answer("which of the following numbers are primes: 729, 443, 373, 577"));
    }

    @Test
    public void should_plusmult_numbers(){
        assertEquals("26",server.answer("what is 7 plus 19"));
        assertEquals("55",server.answer("what is 11 multiplied by 5"));
    }

    @Test
    public void testPrime() throws Exception {
        String answer = server.answer("which of the following numbers are primes: 13, 15");


    }
}
