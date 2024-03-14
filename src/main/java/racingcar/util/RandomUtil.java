package racingcar.util;

import java.util.Random;

public class RandomUtil {
    private static final int BOUND = 10;
    private static final Random random = new Random();

    public static int randInt() {
        return random.nextInt(BOUND);
    }
}
