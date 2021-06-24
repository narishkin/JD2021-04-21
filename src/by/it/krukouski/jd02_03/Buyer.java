package by.it.krukouski.jd02_03;

import java.util.ArrayList;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean waitFlag;

    private final Store store;

    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }

    Object getMonitor() {
        return this;
    }

    public Buyer(long number, Store store) {
        super("Buyer № " + number + " ");
        this.store = store;
        store.getManager().addNewBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
        store.getManager().completeBuyer();
    }

    private void goToQueue() {
        synchronized (this) {
            store.getQueueBuyers().add(this);
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
    public void enterToMarket() {
        System.out.println(this + "Enter to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "Start choose goods");
        int timeout = RandomHelper.random(500, 2000);
        TimerHelper.sleep(timeout);
        System.out.println(this + "Finish choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + "Go out market");

    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "Take Basket");
    }

    @Override
    public void putGoodsToBasket() {
        int countGoods = RandomHelper.random(1, 4);
        int timeout = RandomHelper.random(500, 2000);
        for (int i = 0; i < countGoods; i++) {
            ArrayList<String> strings = new ArrayList<>(HashMapGoods.getHashMap().keySet());
            String good = strings.get(RandomHelper.random(strings.size() - 1));
            TimerHelper.sleep(timeout);
            System.out.println(this + "put " + good + " to basket");

        }
    }
}
