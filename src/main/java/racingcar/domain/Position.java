package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int MOVE_NUM = 4;
    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position은 음수가 될 수 없습니다.");
        }
        this.position = position;
    }

    public void increment(int number) {
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
