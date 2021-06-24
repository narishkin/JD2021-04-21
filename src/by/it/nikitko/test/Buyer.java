package by.it.nikitko.test;

import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer,UseBasket {
    private static final Semaphore semaphore = new Semaphore(20);
    private boolean waitFlag;
    private boolean pensioner;
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
        try {
            semaphore.acquire();
            System.out.println(this+" begin choose goods " );
            if (pensioner) {
                TimeUtils.sleep(by.it.nikitko.test.RandomUtils.random(500, 3000));
            } else {
                TimeUtils.sleep(RandomUtils.random(500, 2000));
            }
            System.out.println(this+" finished choose goods");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

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

    @Override
    public void takeBasket() {

    }

    @Override
    public void putGoodsToBasket() {

    }
}
