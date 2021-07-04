package by.it.zhurauleu.jd02_01;

public class TimerHelper {


    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Config.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
