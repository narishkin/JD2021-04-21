package by.it._classwork_.jd02_02;

public class Buyer extends Thread implements IBuyer {

    private boolean waitFlag;

    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }

    Object getMonitor() {
        return this;
    }

    public Buyer(long number) {
        super("Buyer № " + number + " ");
        Dispatcher.addNewBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        Dispatcher.completeBuyer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "entered the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started choose goods");
        int timeout = RandomHelper.random(500, 2000);
        TimerHelper.sleep(timeout);
        System.out.println(this + "finished choose goods");
    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            QueueBuyers.add(this);
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
        System.out.println(this + "leaves the market");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
