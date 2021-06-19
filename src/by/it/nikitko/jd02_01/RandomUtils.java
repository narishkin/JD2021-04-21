package by.it.nikitko.jd02_01;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    static int random (int min,int max){
        return min + RANDOM.nextInt(max-min+1);
    }
    static int random (int max){
        return RANDOM.nextInt(max+1);
    }




}
