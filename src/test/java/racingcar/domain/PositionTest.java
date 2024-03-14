package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    void create() {
        assertDoesNotThrow(() -> new Position());

        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    void valid() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Position(-1))
                .withMessage("position은 음수가 될 수 없습니다.");
    }

    @Test
    void moved() {
        Position position = new Position();

        position.move(4);

        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    void notMoved() {
        Position position = new Position();

        position.move(3);

        assertThat(position).isEqualTo(new Position(0));
    }
}
