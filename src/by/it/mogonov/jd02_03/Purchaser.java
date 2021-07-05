package by.it.mogonov.jd02_03;

public class Purchaser extends Thread implements LPurchaser {

    private boolean waitFlag;

    private final Korona korona;


    public void setWaitFlag(boolean waitFlag) { this.waitFlag = waitFlag; }

    Object getMonitor() { return this; }

    public Purchaser(long number, Korona korona) {
        super("Purchaser № " + number + " ");
        this.korona = korona;
    }

    @Override
    public void run() {
        goToKorona();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void goToKorona() {
        System.out.println(this + "filling the Korona");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "start");
        int timeout = Randomaser.random(500, 2000);
        Timer.sleep(timeout);
        System.out.println(this + "finish");
    }

    public void goToQueue() {
        synchronized (this) {
            korona.getQueuePurchaser().add(this);
            try {
                waitFlag = true;
                while (waitFlag) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "leave");
    }


    @Override
    public String toString() { return this.getName(); }
}







