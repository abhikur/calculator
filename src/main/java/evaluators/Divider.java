package evaluators;

import utility.DoubleNumberUtility;

import java.util.regex.Pattern;

public class Divider extends Evaluator {

    private static final String DIVIDE_REGEX = "-*(\\d+\\.*\\d*/-*\\d+\\.*\\d*)";

    public double evaluate(String expression) {
        String[] numbers = expression.split("/");
        return DoubleNumberUtility.round2Places(Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]));
    }

    @Override
    public Pattern pattern() {
        return Pattern.compile(DIVIDE_REGEX);
    }
}
