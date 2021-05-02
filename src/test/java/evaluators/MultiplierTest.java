package evaluators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplierTest {
    Multiplier multiplier = new Multiplier();

    @Test
    void evaluate_shouldAddTwoOperands() {
        assertEquals(12, multiplier.evaluate("2*6"));
        assertEquals(-4, multiplier.evaluate("-2*2"));
        assertEquals(-10.41, multiplier.evaluate("-4.30*2.42"));
    }

    @Test
    void pattern_shouldReturnPatternForMultiplyOperation() {
        assertEquals("-*(\\d+\\.*\\d*\\*-*\\d+\\.*\\d*)", multiplier.pattern().toString());
    }

    @Test
    void evaluateExpressionRecursively_shouldEvaluateRecursiveOperations() {
        assertEquals("64.0", multiplier.evaluateExpressionRecursively("2*2*2*8"));
        assertEquals("10.09", multiplier.evaluateExpressionRecursively("2.34*4.31"));
        assertEquals("-385.85", multiplier.evaluateExpressionRecursively("-4*2.4*2.2*8.7*2.1"));
    }
}
