package evaluators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractorTest {
    Subtractor subtractor = new Subtractor();

    @Test
    void evaluate_shouldAddTwoOperands() {
        assertEquals(4, subtractor.evaluate("6-2"));
        assertEquals(-6, subtractor.evaluate("-4-2"));
        assertEquals(-6.72, subtractor.evaluate("-4.30-2.42"));
    }

    @Test
    void pattern_shouldReturnPatternForSubtractOperation() {
        assertEquals("-*(\\d+\\.*\\d*-\\d+\\.*\\d*)", subtractor.pattern().toString());
    }

    @Test
    void evaluateExpressionRecursively_shouldEvaluateRecursiveOperations() {
        assertEquals("-4.0", subtractor.evaluateExpressionRecursively("8-2-2-8"));
        assertEquals("-1.97", subtractor.evaluateExpressionRecursively("2.34-4.31"));
        assertEquals("-19.4", subtractor.evaluateExpressionRecursively("-4-2.4-2.2-8.7-2.1"));
    }
}
