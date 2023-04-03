package atatu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class MathTest {
    
    @Test
    public void additionTest() {
        assertEquals("10 + 2 must be equal 12", 12, Math.addition(10, 2));
    }
    
    @Test
    public void substractionTest() {
        assertEquals("10 - 2 must be equal 8", 8, Math.substraction(10, 2));
    }

    @Test
    public void multiplicationTest() {
        assertEquals("10 * 2 must be equal 20", 20, Math.multiplication(10, 2));
    }
    
    @Test(expected = DivideByZeroException.class)
    public void zeroDivisionTest() throws DivideByZeroException {
        Math.division(10, 0);
    }

    @Test
    public void divisionTest() throws DivideByZeroException {
        assertEquals("10 / 2 must be equal 5", 5, Math.division(10, 2));
    }

}
