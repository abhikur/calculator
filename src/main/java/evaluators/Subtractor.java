package evaluators;

import utility.DoubleNumberUtility;

import java.util.regex.Pattern;

public class Subtractor extends Evaluator {

    private static final String SUBTRACT_REGEX = "-*(\\d+\\.*\\d*-[\\+-]*\\d+\\.*\\d*)";

    public double evaluate(String expression) {
        double[] numbers = extractNumbers(expression);
        double firstNumber = numbers[0];
        double secondNumber = numbers[1];
        return DoubleNumberUtility.round2Places(firstNumber - secondNumber);
    }

    @Override
    public Pattern pattern() {
        return Pattern.compile(SUBTRACT_REGEX);
    }

    private double[] extractNumbers(String expression) {
        String[] numbers = expression.split("-");
        double firstNumber = 0;
        double secondNumber = 0;
        if (isFirstNumberNegative(numbers)) {
            firstNumber = Double.parseDouble("-"+numbers[1]);
            secondNumber = Double.parseDouble(numbers[2]);
        } else if (areBothNumbersNegative(numbers)) {
            firstNumber = Double.parseDouble("-"+numbers[1]);
            secondNumber = Double.parseDouble("-"+numbers[3]);
        } else {
            firstNumber = Double.parseDouble(numbers[0]);
            secondNumber = Double.parseDouble(numbers[1]);
        }
        return new double[]{firstNumber, secondNumber};
    }

    private boolean areBothNumbersNegative(String[] numbers) {
        return numbers.length == 4;
    }

    private boolean isFirstNumberNegative(String[] numbers) {
        return numbers.length == 3;
    }
}
