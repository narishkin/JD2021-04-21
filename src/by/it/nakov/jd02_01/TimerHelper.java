package by.it.nakov.jd02_01;

public class TimerHelper {
    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Config.TIME_COMPRESSOR);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
