package validators;

import java.util.regex.Pattern;

public class ExpressionValidator {

    private static final String INVALID_CHAR_REGEX = "[^\\d\\+\\/\\*-\\.\\(\\)]";
    private static final String MULTIPLE_OPERATORS_TOGETHER_REGEX = "\\d+[\\*\\/\\+\\-]{2,}\\d+";

    public static void validate(String expression) {
        Pattern pattern = Pattern.compile(INVALID_CHAR_REGEX);
        Pattern multipleOperatorsPattern = Pattern.compile(MULTIPLE_OPERATORS_TOGETHER_REGEX);
        if (pattern.matcher(expression).find()) {
            throw new Error("Invalid character in expression");
        }
        if (multipleOperatorsPattern.matcher(expression).find()) {
            throw new Error("Multiple operators together in expression");
        }
    }
}
