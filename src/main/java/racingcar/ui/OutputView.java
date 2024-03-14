package racingcar.ui;

import java.util.List;

public class OutputView {
    private static final String RESULT_DELIMITER = " : ";
    private static final String HYPHEN = "-";
    private static final String WINNER_DELIMITER = ", ";

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printRaceResult(String name, int position) {
        String result = "";
        for (int i = 0; i < position; i++) {
            result += HYPHEN;
        }
        System.out.println(String.join(RESULT_DELIMITER, name, result));
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printWinners(List<String> winnerNames) {
        String winners = String.join(WINNER_DELIMITER, winnerNames);
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
