package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class RacingCar {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCar(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        // 사용자로부터 입력
        Cars cars = inputCarNames();
        int number = inputView.inputAttemptNumber();

        // 자동차들 이동
        List<String> results = moveCars(cars, number);

        // 실행 결과
        printResults(results, cars.size());

        // 우승자
        printWinners(cars);
    }

    private Cars inputCarNames() {
        List<String> names = inputView.inputCarNames();
        return Cars.from(names);
    }

    private List<String> moveCars(Cars cars, int number) {
        List<String> results = new ArrayList<>();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        for (int i = 0; i < number; i++) {
            cars.moveForward(numberGenerator);
            results.addAll(cars.getResults());
        }

        return results;
    }

    private void printResults(List<String> results, int size) {
        outputView.printResults(results, size);
    }

    private void printWinners(Cars cars) {
        List<String> winners = cars.getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        outputView.printWinners(winners);
    }
}
