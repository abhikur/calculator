package evaluators;

import utility.DoubleNumberUtility;

import java.util.regex.Pattern;

public class Subtractor extends Evaluator {

    private static final String SUBTRACT_REGEX = "-*(\\d+\\.*\\d*-\\d+\\.*\\d*)";

    public double evaluate(String expression) {
        String[] numbers = expression.split("-");
        double firstNumber = numbers.length > 2 ? Double.parseDouble("-"+numbers[1]) : Double.parseDouble(numbers[0]);
        double secondNumber = numbers.length > 2 ? Double.parseDouble(numbers[2]) : Double.parseDouble(numbers[1]);
        return DoubleNumberUtility.round2Places(firstNumber - secondNumber);
    }

    @Override
    public Pattern pattern() {
        return Pattern.compile(SUBTRACT_REGEX);
    }
}
