package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    @Test
    void inRange() {
        // given
        NumberGenerator generator = new RandomNumberGenerator();

        // when
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int number = generator.generate();
            numbers.add(number);
        }

        // then
        for (Integer number : numbers) {
            assertThat(number).isGreaterThanOrEqualTo(0);
            assertThat(number).isLessThanOrEqualTo(9);
        }
    }
}
