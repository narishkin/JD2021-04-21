package by.it.mogonov.jd02_03;

public class Cashier implements Runnable {

    private final int number;

    private final Korona korona;

    public Cashier(int number, Korona korona) {
        this.number = number;
        this.korona = korona;
    }


    @Override
    public void run() {
        System.out.println(this + "open");
        while (!korona.getManager().koronaClosed()) {
            Purchaser currentPurchaser = korona.getQueuePurchaser().poll();
            if (currentPurchaser != null) {
                System.out.println(this + "start service " + currentPurchaser);
                int timeService = Randomaser.random(2000, 5000);
                Timer.sleep(timeService);
                synchronized (currentPurchaser.getMonitor()) {
                    currentPurchaser.setWaitFlag(false);
                    currentPurchaser.notify();
                }
                System.out.println(this + "finish service " + currentPurchaser);
            } else {
                System.out.println(this + "sleep");
                Timer.sleep(1000);
            }
        }
        System.out.println(this + " close");
    }

    @Override
    public String toString() {
        return String.format("\rCashier #%d ", number);
    }


}