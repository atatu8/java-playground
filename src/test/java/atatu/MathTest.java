package atatu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.junit.Before;

public class MathTest {
    long a;
    long b;

    @Before
    public void setUp() {
        a = 10;
        b = 0;
    }

    @Test
    public void additionTest() {
        int result = 12;
        assertEquals("10 + 2 must be equal 12", result, Math.addition(a, b));
    }

    @Test
    public void substractionTest() {
        int result = 8;
        assertEquals("10 - 2 must be equal 8", result, Math.substraction(a, b));
    }

    @Test
    public void multiplicationTest() {
        int result = 20;
        assertEquals("10 * 2 must be equal 20", result, Math.multiplication(a, b));
    }

    @Test
    public void devisionTest() throws DevideByZeroException {
        int result = 5;
        assertEquals("10 / 2 must be equal 5", result, Math.devision(a, b));
    }
}
