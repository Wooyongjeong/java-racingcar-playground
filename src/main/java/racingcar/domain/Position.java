package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int MIN_NUM = 0;
    private static final int BOUND = 9;
    private static final int MOVE_NUM = 4;
    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        if (position < MIN_NUM) {
            throw new IllegalArgumentException("position은 음수가 될 수 없습니다.");
        }
        this.position = position;
    }

    public void move(int number) {
        if (number > BOUND || number < MIN_NUM) {
            throw new IllegalArgumentException("0~9의 숫자가 아닙니다.");
        }
        if (number < MOVE_NUM) {
            return;
        }
        this.position += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
