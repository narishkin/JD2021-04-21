package by.it.nikitko.jd02_03;

public class TimeUtils {
    static void sleep(int sleepTime) {
        try {
            Thread.sleep(sleepTime/ Config.TIME_FACTOR);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
