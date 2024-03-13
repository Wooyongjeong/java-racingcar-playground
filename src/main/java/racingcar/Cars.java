package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private Cars(List<String> names) {
        this.cars = names.stream()
                .map(Car::from)
                .collect(Collectors.toList());
    }

    public static Cars from(List<String> names) {
        return new Cars(names);
    }

    public void moveForward(NumberGenerator numberGenerator) {
        cars.forEach(car -> {
            int number = numberGenerator.generate();
            car.moveForward(number);
        });
    }

    public void moveForward(NumberGenerators numberGenerators) {
        validateFitSize(numberGenerators);
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            NumberGenerator numberGenerator = numberGenerators.get(i);
            int number = numberGenerator.generate();
            car.moveForward(number);
        }
    }

    private void validateFitSize(NumberGenerators numberGenerators) {
        if (!numberGenerators.isFitSize(cars.size())) {
            throw new IllegalArgumentException("숫자 생성기를 여러 개 사용하기 위해서는 자동차 개수와 같은 크기의 리스트여야 합니다.");
        }
    }

    public List<String> getResults() {
        return cars.stream()
                .map(Car::getResult)
                .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        int maxMoveCount = getMaxMoveCount();
        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .collect(Collectors.toList());
    }

    private int getMaxMoveCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("maxMoveCount를 구할 수 없습니다."));
    }
}
