import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void shouldEvaluateGivenExpression() {
        Calculator calculator = new Calculator();

        assertEquals(9, calculator.evaluate("2.3+3.3+3.4"));
        assertEquals(-3.6, calculator.evaluate("2.6-3.2-3"));
        assertEquals(2, calculator.evaluate("2+3-3"));
        assertEquals(2, calculator.evaluate("2+3-3"));
        assertEquals(-2, calculator.evaluate("-2+3-3"));
        assertEquals(2, calculator.evaluate("6/3"));
        assertEquals(2.5, calculator.evaluate("5/2"));
        assertEquals(6, calculator.evaluate("6/2+3"));
        assertEquals(20, calculator.evaluate("60/6+10"));
        assertEquals(3, calculator.evaluate("6+4/2-10/2"));
        assertEquals(-5, calculator.evaluate("-10/2"));
        assertEquals(5, calculator.evaluate("-10/-2"));
        assertEquals(-20, calculator.evaluate("-10*2"));
        assertEquals(20, calculator.evaluate("-10*-2"));
        assertEquals(26.25, calculator.evaluate("-10.5*-2.5"));
    }

    @Test
    void shouldThrowExceptionForInvalidExpression() {
        Calculator calculator = new Calculator();

        Error exception = assertThrows(Error.class, () -> calculator.evaluate("-20a*5"));

        assertEquals("Invalid character in expression", exception.getMessage());
    }
}
