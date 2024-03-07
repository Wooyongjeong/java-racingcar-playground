package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = "[,:]";
    private static final String NEGATIVE = "-";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (null == text || text.isEmpty()) {
            return 0;
        }
        validateNegative(text);
        if (text.length() == 1) {
            return Integer.parseInt(text);
        }
        return calculate(text);
    }

    public static void validateNegative(String text) {
        if (text.contains(NEGATIVE)) {
            throw new IllegalArgumentException("음수는 계산할 수 없습니다.");
        }
    }

    public static int calculate(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            return calculateCustomDelimiter(m);
        }
        return calculate(text, DELIMITER);
    }

    public static int calculateCustomDelimiter(Matcher m) {
        String customDelimiter = m.group(1);
        String text = m.group(2);
        return calculate(text, customDelimiter);
    }

    public static int calculate(String text, String delimiter) {
        return Arrays.stream(text.split(delimiter))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
