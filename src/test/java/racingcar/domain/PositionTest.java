package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
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
    void increment() {
        Position position = new Position();

        position.increment(4);

        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    void notIncrement() {
        Position position = new Position();

        position.increment(3);

        assertThat(position).isEqualTo(new Position(0));
    }
}
