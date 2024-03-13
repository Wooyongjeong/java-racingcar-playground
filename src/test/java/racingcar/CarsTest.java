package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {
    Cars cars;
    static List<String> names;
    static NumberGenerator randomNumberGenerator;

    static class FixedNumberGenerator implements NumberGenerator {
        private final int number;

        public FixedNumberGenerator(int number) {
            this.number = number;
        }

        @Override
        public int generate() {
            return number;
        }
    }

    @BeforeAll
    static void beforeAll() {
        names = Arrays.asList("pobi", "crong", "honux");
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @BeforeEach
    void setUp() {
        cars = Cars.from(names);
    }

    @Test
    void moveForward() {
        for (int i = 0; i < 100; i++) {
            assertDoesNotThrow(() -> cars.moveForward(randomNumberGenerator));
        }
    }

    @Test
    void moved() {
        // given
        int number = 4;

        // when
        cars.moveForward(new FixedNumberGenerator(number));

        // then
        List<String> results = cars.getResults();
        assertThat(results)
                .allMatch(str ->
                        str.contains("-") && str.indexOf("-") == str.lastIndexOf("-"));
    }

    @Test
    void notMoved() {
        // given
        int number = 3;

        // when
        cars.moveForward(new FixedNumberGenerator(number));

        // then
        List<String> results = cars.getResults();
        assertThat(results).doesNotContainSequence("-");
    }

    @Test
    void winner() {
        // given
        List<NumberGenerator> generators = Arrays.asList(
                new FixedNumberGenerator(0),
                new FixedNumberGenerator(1),
                new FixedNumberGenerator(4)
        );
        NumberGenerators numberGenerators = new NumberGenerators(generators);

        // when
        for (int i = 0; i < 5; i++) {
            cars.moveForward(numberGenerators);
        }

        // then
        String expectedName = "honux";
        int expectedMoveCount = 5;
        List<Car> winners = cars.getWinners();

        assertThat(winners).isNotNull();
        assertThat(winners).isNotEmpty();
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo(expectedName);
        assertThat(winners.get(0).getMoveCount()).isEqualTo(expectedMoveCount);
    }

    @Test
    void winners() {
        // given
        List<NumberGenerator> generators = Arrays.asList(
                new FixedNumberGenerator(4),
                new FixedNumberGenerator(4),
                new FixedNumberGenerator(0)
        );
        NumberGenerators numberGenerators = new NumberGenerators(generators);

        // when
        for (int i = 0; i < 5; i++) {
            cars.moveForward(numberGenerators);
        }

        // then
        String expectedName1 = "pobi";
        String expectedName2 = "crong";
        int expectedMoveCount = 5;
        List<Car> winners = cars.getWinners();

        assertThat(winners).isNotNull();
        assertThat(winners).isNotEmpty();
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo(expectedName1);
        assertThat(winners.get(1).getName()).isEqualTo(expectedName2);
        assertThat(winners.get(0).getMoveCount()).isEqualTo(expectedMoveCount);
        assertThat(winners.get(1).getMoveCount()).isEqualTo(expectedMoveCount);
    }
}
