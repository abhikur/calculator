package evaluators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DividerTest {
    Divider divider = new Divider();

    @Test
    void evaluate_shouldDivideTwoOperands() {
        assertEquals(1, divider.evaluate("2/2"));
        assertEquals(-1, divider.evaluate("-2/2"));
        assertEquals(-1.79, divider.evaluate("-4.3/2.4"));
    }

    @Test
    void pattern_shouldReturnPatternForDivideOperation() {
        assertEquals("-*(\\d+\\.*\\d*/-*\\d+\\.*\\d*)", divider.pattern().toString());
    }

    @Test
    void evaluateExpressionRecursively_shouldEvaluateRecursiveOperations() {
        assertEquals("0.5", divider.evaluateExpressionRecursively("16/2/2/8"));
        assertEquals("0.54", divider.evaluateExpressionRecursively("2.34/4.31"));
        assertEquals("-0.04", divider.evaluateExpressionRecursively("-4/2.4/2.2/8.7/2.1"));
    }
}
