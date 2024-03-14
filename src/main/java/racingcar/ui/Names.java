package racingcar.ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private final List<String> names;

    public Names(String input) {
        if (!input.matches("^[a-zA-Z가-힣0-9]+(?:,[a-zA-Z가-힣0-9]+)*$")) {
            throw new IllegalArgumentException("알파벳, 한글, 숫자로 이루어진 자동차 이름과 쉼표만 입력해 주세요.");
        }
        this.names = Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return names;
    }
}
