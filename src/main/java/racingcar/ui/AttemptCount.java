package racingcar.ui;

public class AttemptCount {
    private final int count;

    public AttemptCount(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
        this.count = Integer.parseInt(input);
    }

    public int getCount() {
        return count;
    }
}
