package by.it.nikitko.test;

public class TimeUtils {
    static void sleep(int sleepTime) {
        try {
            Thread.sleep(sleepTime/ Config.TIME_FACTOR);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
