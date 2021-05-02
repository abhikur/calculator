package evaluators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Evaluator {
    abstract double evaluate(String expression);
    abstract Pattern pattern();

    public String evaluateExpressionRecursively(String expression) {
        String updatedExpression = expression;
        Matcher patternMatcher = this.pattern().matcher(expression);
        if (patternMatcher.find()) {
            double result = this.evaluate(patternMatcher.group());
            updatedExpression = patternMatcher.replaceFirst(String.valueOf(result));
            Matcher remainingMatches = this.pattern().matcher(updatedExpression);
            if (remainingMatches.find()) {
                updatedExpression = evaluateExpressionRecursively(updatedExpression);
            }
        }
        return updatedExpression;
    }
}
