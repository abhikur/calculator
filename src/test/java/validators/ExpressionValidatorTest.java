package validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpressionValidatorTest {

    @Test
    void validate_shouldThrowExceptionForInvalidExpression() {
        Error error = assertThrows(Error.class, () -> {
            ExpressionValidator.validate("-2a+2b");
        });

        assertEquals("Invalid character in expression", error.getMessage());
    }

    @Test
    void validate_shouldNotThrowExceptionForValidExpression() {
        ExpressionValidator.validate("-2+2");
    }
}