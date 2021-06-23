package by.it._classwork_.jd02_03;

import java.util.concurrent.ThreadLocalRandom;

public class RandomHelper {

    private RandomHelper() {
    }

    static int random(int min, int max) {
        return min + ThreadLocalRandom.current().nextInt(max - min + 1);
    }

    static int random(int max) {
        return random(0, max);
    }
}
