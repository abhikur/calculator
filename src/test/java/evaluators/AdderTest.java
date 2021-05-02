package evaluators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdderTest {
    Adder adder = new Adder();

    @Test
    void evaluate_shouldAddTwoOperands() {
        assertEquals(4, adder.evaluate("2+2"));
        assertEquals(0, adder.evaluate("-2+2"));
        assertEquals(-1.9, adder.evaluate("-4.3+2.4"));
    }

    @Test
    void pattern_shouldReturnPatternForAddOperation() {
        assertEquals("-*(\\d+\\.*\\d*\\+\\d+\\.*\\d*)", adder.pattern().toString());
    }

    @Test
    void evaluateExpressionRecursively_shouldEvaluateRecursiveOperations() {
        assertEquals("20.0", adder.evaluateExpressionRecursively("4+2+6+8"));
        assertEquals("6.65", adder.evaluateExpressionRecursively("2.34+4.31"));
        assertEquals("11.4", adder.evaluateExpressionRecursively("-4+2.4+2.2+8.7+2.1"));
    }
}
