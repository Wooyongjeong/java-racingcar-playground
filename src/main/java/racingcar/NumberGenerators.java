package racingcar;

import java.util.List;

public class NumberGenerators {
    private final List<NumberGenerator> numberGenerators;

    public NumberGenerators(List<NumberGenerator> numberGenerators) {
        this.numberGenerators = numberGenerators;
    }

    public NumberGenerator get(int index) {
        return numberGenerators.get(index);
    }

    public boolean isFitSize(int size) {
        return numberGenerators.size() == size;
    }
}
