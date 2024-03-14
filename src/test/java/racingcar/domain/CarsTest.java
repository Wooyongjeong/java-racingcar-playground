package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void findWinners() {
        Car pobi = new Car("pobi", 2);
        Car crong = new Car("crong", 2);
        Car honux = new Car("honux", 1);

        List<Car> original = Arrays.asList(pobi, crong, honux);
        Cars cars = new Cars(original);

        assertThat(cars.findWinners()).containsExactly(pobi, crong);
    }
}
