package by.it.mogonov.jd02_03;

public class Timer {

    private Timer() {

    }

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
