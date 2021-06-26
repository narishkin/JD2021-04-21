package by.it.krukouski.jd02_03;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean waitFlag;

    private static final Semaphore semaphore = new Semaphore(20);

    private final Store store;

    private final int number;

    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }

    Object getMonitor() {
        return this;
    }

    public Buyer(int number, Store store) {
        this.number = number;
        this.setName("Buyer " + number);
        this.store=store;
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

    @Override
    public void goToQueue() {
        synchronized (this) {
            System.out.printf("Buyer №%5d go to queue\n", number);
            store.getQueueBuyers().add(this);
            cashierToWork();
            try {
                waitFlag=true;
                this.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void enterToMarket() {
        try {
            semaphore.acquire();
            System.out.println(this + " Enter to market");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " Start choose goods");
        int timeout = RandomHelper.random(500, 2000);
        TimerHelper.sleep(timeout);
        System.out.println(this + " Finish choose goods");
    }

    @Override
    public void goOut() {
        semaphore.release();
        System.out.println(this + " Go out market");

    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " Take Basket");
        int timeout = RandomHelper.random(500, 2000);
        TimerHelper.sleep(timeout);
    }

    @Override
    public void putGoodsToBasket() {
        int totalSum=0;
        int countGoods = RandomHelper.random(1, 4);
        int timeout = RandomHelper.random(500, 2000);
        for (int i = 0; i < countGoods; i++) {
            ArrayList<String> strings = new ArrayList<>(HashMapGoods.getHashMap().keySet());
            String good = strings.get(RandomHelper.random(strings.size() - 1));
            Integer price = HashMapGoods.getHashMap().get(good);
            TimerHelper.sleep(timeout);
            System.out.println(this + " put " + good + " to basket with price " + price);
            totalSum+=price;
        }
        System.out.println(this + " have a total price= " + totalSum);
    }

    private void cashierToWork() {
        synchronized (this) {
            int cashierNeededToWork = (int) Math.ceil(store.getQueueBuyers().getQueueSize() / Config.QUEUE_LENGTH);
            int cashierWorked = QueueCashiers.getCashierWorked();
            while (QueueCashiers.getQueueSize() > 0 & cashierWorked < cashierNeededToWork) {
                Cashier cashier = QueueCashiers.poll();
                synchronized (cashier.getMonitor()) {
                    cashierWorked=QueueCashiers.getCashierWorked();
                    cashier.setWaitFlag(false);
                    cashier.notify();
                }
            }
        }
    }


}
