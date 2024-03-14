package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameTest {
    @Test
    void create() {
        assertDoesNotThrow(() -> new Name("pobi"));
    }

    @Test
    void nullOrEmpty() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(null))
                .withMessage("자동차 이름이 빈 값입니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(""))
                .withMessage("자동차 이름이 빈 값입니다.");
    }

    @Test
    void lengthOverMaxLength() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name("abcdef"))
                .withMessage("자동차 이름은 5글자 이하여야 합니다.");
    }
}
