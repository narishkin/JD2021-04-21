package by.it.sapazhkou.jd02_01;

public class TimerHelper {

    public static void sleep(int millisecond) {
        try {
            Thread.sleep(millisecond / Configs.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
