package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void create() {
        assertDoesNotThrow(() -> new Car("pobi"));
    }

    @Test
    void move() {
        Car car = new Car("pobi");

    }
}
