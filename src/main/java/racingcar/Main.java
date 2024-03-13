package racingcar;

import java.util.Scanner;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();

        RacingCar racingCar = new RacingCar(inputView, outputView);
        racingCar.play();

        scanner.close();
    }
}
