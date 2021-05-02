package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleNumberUtilityTest {

    @Test
    void round2Places_shouldRoundNumberTo2Places() {
        assertEquals(2.24 ,DoubleNumberUtility.round2Places(2.244444));
        assertEquals(2.25 ,DoubleNumberUtility.round2Places(2.2456));
    }
}
