package by.it.krukouski.jd02_03;

public class TimerHelper {

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Config.KEY_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
