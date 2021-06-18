package by.it.naryshkin.jd02_01;

import java.util.Random;

public class RandomHelper {
    final static Random RANDOM = new Random();

    static int random(int min, int max) {
        return min + RANDOM.nextInt(max - min + 1);
    }

    static int random(int max) {
        return  random(0,max);
    }

    static double random(double min, double max) {
        return min + (max-min)*RANDOM.nextDouble();
    }
}
