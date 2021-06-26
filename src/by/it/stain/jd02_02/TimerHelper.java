package by.it.stain.jd02_02;

public class TimerHelper {
    static void sleep(int waitingTime){
        try{
            Thread.sleep(waitingTime/ Configuration.SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
