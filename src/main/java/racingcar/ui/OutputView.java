package racingcar.ui;

import java.util.List;

public class OutputView {
    public void printResults(List<String> results, int size) {
        System.out.println("실행 결과");
        for (int i = 0; i < results.size(); i++) {
            if (i % size == 0 && i > 0) {
                System.out.println();
            }
            String result = results.get(i);
            System.out.println(result);
        }
    }

    public void printWinners(List<String> winners) {
        String s = String.join(", ", winners);
        System.out.printf("%s가 최종 우승했습니다.%n", s);
    }
}
