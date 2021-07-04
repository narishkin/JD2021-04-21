package by.it.zhurauleu.jd02_02;

import java.util.Random;

public class RandomHelper {
    private static final Random RANDOM = new Random();

    static int random(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    static int random(int max) {
        return random(0, max);
    }
}
