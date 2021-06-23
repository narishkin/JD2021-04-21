package by.it.sapazhkou.jd02_01;

import java.util.Random;

public class RandomHelper {

    private static final Random random = new Random();

    static int randomValue( int min, int max){

        return random.nextInt(max-min+1) + min;
    }
    static int randomValue(int max){
        return randomValue(0, max);
    }

}
