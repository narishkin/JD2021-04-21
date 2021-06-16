package by.it._classwork_.jd02_01;

import java.util.Random;

public class TimerHelper {





    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Config.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
