package by.it.mogonov.jd02_02;

public class Timer {
    static  void sleep(int timeout) {
        try {
            Thread.sleep(timeout/ Conctant.SPEED);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}
