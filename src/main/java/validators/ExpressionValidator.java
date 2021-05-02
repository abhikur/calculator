package validators;

import java.util.regex.Pattern;

public class ExpressionValidator {

    private static final String INVALID_CHAR_REGEX = "[^\\d\\+\\/\\*-\\.]";

    public static void validate(String expression) {
        Pattern pattern = Pattern.compile(INVALID_CHAR_REGEX);
        if (pattern.matcher(expression).find()) {
            throw new Error("Invalid character in expression");
        }
    }
}
