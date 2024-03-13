package racingcar.ui;

public class AttemptNumber {
    private final int number;

    private AttemptNumber(String input) {
        validate(input);
        this.number = Integer.parseInt(input);
    }

    public static AttemptNumber from(String input) {
        return new AttemptNumber(input);
    }

    private void validate(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < 1) {
                throw new IllegalArgumentException("1 이상의 숫자를 입력해 주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public int getNumber() {
        return number;
    }
}
