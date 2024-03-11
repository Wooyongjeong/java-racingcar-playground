package racingcar;

public class Name {
    private static final int SIZE = 5;
    private final String name;

    private Name(String name) {
        validate(name);
        this.name = name;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    private void validate(String name) {
        if (null == name || name.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해 주세요.");
        }
        if (name.length() > SIZE) {
            throw new IllegalArgumentException("이름은 5자 이하로 입력해 주세요.");
        }
    }

    public String getName() {
        return name;
    }
}
