import evaluators.Evaluator;
import evaluators.Evaluators;
import validators.ExpressionValidator;

import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

    private static final String ONLY_DIGITS_REGEX = "-*\\d+\\.*\\d*";

    public double evaluate(String expression) {
        ExpressionValidator.validate(expression);

        List<Evaluator> evaluators = Evaluators.bodmasEvaluators();
        String updatedExpression = expression;
        for (Evaluator evaluator : evaluators) {
            updatedExpression = evaluator.evaluateExpressionRecursively(updatedExpression);
        }
        boolean onlyDigit = Pattern.matches(ONLY_DIGITS_REGEX, updatedExpression);
        return onlyDigit ? Double.parseDouble(updatedExpression) : evaluate(updatedExpression);
    }
}
