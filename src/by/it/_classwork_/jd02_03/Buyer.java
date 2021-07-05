package by.it._classwork_.jd02_03;

public class Buyer extends Thread implements IBuyer {

    private boolean waitFlag;

    private final Market market;


    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }

    Object getMonitor() {
        return this;
    }

    public Buyer(long number, Market market) {
        super("Buyer № " + number + " ");
        this.market = market;
        market.getDispatcher().addNewBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        market.getDispatcher().completeBuyer();
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
            market.getQueueBuyers().add(this);
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
