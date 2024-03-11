package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"abcde", "a", "ab", "abc", "abcd"})
    void initWithValidName(String name) {
        assertDoesNotThrow(() -> Car.from(name));
    }

    @Test
    void initWithInvalidName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.from(null))
                .withMessageContaining("이름을 입력해 주세요.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.from(""))
                .withMessageContaining("이름을 입력해 주세요.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.from("jadgiofujqery"))
                .withMessageContaining("이름은 5자 이하로 입력해 주세요.");
    }

    @Test
    void moveForward() {
        Car car = Car.from("car");

        for (int num = 0; num < 10; num++) {
            car.moveForward(num);
        }

        assertThat(car.getMoveCount()).isEqualTo(6);
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 10, -100, 1000})
    void moveForwardWithWrongNum(int num) {
        Car car = Car.from("car");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> car.moveForward(num))
                .withMessageContaining("0~9의 숫자가 아닙니다.");
    }
}
