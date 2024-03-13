package racingcar.ui;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        Names names = Names.from(input);
        return names.getNames();
    }

    public int inputAttemptNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        AttemptNumber attemptNumber = AttemptNumber.from(input);
        return attemptNumber.getNumber();
    }
}
