package by.it.naryshkin.jd02_03;

public class TimerHelper {

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Config.TIME_COMPRESSOR);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void sleep(double timeout) {
        try {
            Thread.sleep((long) timeout / Config.TIME_COMPRESSOR);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
