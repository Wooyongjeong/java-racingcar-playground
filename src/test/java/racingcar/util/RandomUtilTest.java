package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomUtilTest {
    @Test
    void random() {
        for (int i = 0; i < 100; i++) {
            int number = RandomUtil.randInt();

            assertThat(number).isGreaterThanOrEqualTo(0);
            assertThat(number).isLessThan(10);
        }
    }
}
