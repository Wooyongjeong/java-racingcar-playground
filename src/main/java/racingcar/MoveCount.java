package racingcar;

public class MoveCount {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    private static final int MOVE_NUM = 4;
    private static final String MOVE = "-";
    private int count = 0;

    public void report(int num) {
        validate(num);
        if (num >= MOVE_NUM) {
            this.count += 1;
        }
    }

    private void validate(int num) {
        if (num < MIN_NUM || num > MAX_NUM) {
            throw new IllegalArgumentException("0~9의 숫자가 아닙니다.");
        }
    }

    public int getMoveCount() {
        return count;
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(MOVE);
        }
        return result.toString();
    }
}
