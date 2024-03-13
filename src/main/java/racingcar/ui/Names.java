package racingcar.ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final String DELIMITER = ",";
    private final List<String> names;

    private Names(String input) {
        validate(input);
        this.names = Arrays.stream(input.split(DELIMITER)).collect(Collectors.toList());
    }

    public static Names from(String input) {
        return new Names(input);
    }

    private void validate(String input) {
        if (!input.matches("^[a-zA-Z0-9가-힣]+(?:,[a-zA-Z0-9가-힣]+)*$")) {
            throw new IllegalArgumentException("자동차 이름과 쉼표만 입력해 주세요.");
        }
    }

    public List<String> getNames() {
        return names;
    }
}
