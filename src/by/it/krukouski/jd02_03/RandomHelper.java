package by.it.krukouski.jd02_03;

import java.util.Random;

public class RandomHelper {
    private static final Random RANDOM = new Random();

    static int random(int min, int max) {
        return min + RANDOM.nextInt(max - min + 1);
    }


    static int random(int max) {
        return random(0, max);
    }
}
