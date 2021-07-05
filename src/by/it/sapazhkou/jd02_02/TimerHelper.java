package by.it.sapazhkou.jd02_02;

public class TimerHelper {

    public static void sleep(int millisecond) {
        try {
            Thread.sleep(millisecond / Configs.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
