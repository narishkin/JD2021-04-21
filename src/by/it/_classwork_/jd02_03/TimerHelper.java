package by.it._classwork_.jd02_03;

import java.util.Arrays;

public class TimerHelper {

    private TimerHelper() {
    }

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Config.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
