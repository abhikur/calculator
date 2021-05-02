package utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleNumberUtility {
    private static final int ROUND_SCALE = 2;

    public static double round2Places(double d) {
        BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
        bigDecimal = bigDecimal.setScale(ROUND_SCALE, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
