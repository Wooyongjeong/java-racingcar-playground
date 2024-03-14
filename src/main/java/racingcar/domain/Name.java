package racingcar.domain;

public class Name {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (null == name || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 빈 값입니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
