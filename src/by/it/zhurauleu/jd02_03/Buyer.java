package by.it.zhurauleu.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements Runnable, IBuyer, IUseBasket {

    private static final Semaphore MARKET_SEMAPHORE = new Semaphore(Config.MAX_BUYERS_IN_MARKET);

    private final int GOODS_LIMIT = RandomHelper.random(1, 4);

    private int checkSum = 0;

    private boolean waifFlag = false;

    private final List<String> BASKET = new ArrayList<>();


    public void setWaifFlag(boolean waifFlag) {
        this.waifFlag = waifFlag;
    }

    Object getMonitor() {
        return this;
    }

    public Buyer(int num) {
        try {
            MARKET_SEMAPHORE.acquire();
            Dispatcher.addNewBuyer();
            this.setName("buyer №" + num + " ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goToOut();
        Dispatcher.completeBuyer();
    }

    @Override
    public synchronized void goToQueue() {
        QueueBuyers.add(this);
        System.out.println(this + "go to queue");
        MARKET_SEMAPHORE.release();
        waifFlag = true;
        while (waifFlag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "start choose goods");
        int pause = RandomHelper.random(500, 2000);
        TimerHelper.sleep(pause);
        System.out.println(this + "end choose goods");
    }

    @Override
    public void goToOut() {
        System.out.println(this + "left the market");
    }

    @Override
    public void takeBasket() {
        int pause = RandomHelper.random(500, 2000);
        TimerHelper.sleep(pause);
        System.out.println(this + "take basket");
    }

    @Override
    public void putGoodsToBasket() {
        ArrayList<String> goodNameList = new ArrayList<>(Goods.getGoods().keySet());
        int pause = RandomHelper.random(2000, 5000);
        for (int i = 0; i < GOODS_LIMIT; i++) {
            TimerHelper.sleep(pause);
            int goodNameIndex = RandomHelper.random(goodNameList.size() - 1);
            BASKET.add(goodNameList.get(goodNameIndex));
            checkSum += Goods.getGoods().get(goodNameList.get(goodNameIndex));
            System.out.println(this + "put " + goodNameList.get(goodNameIndex) +
                    " in the basket with price = " + Goods.getGoods().get(goodNameList.get(goodNameIndex)));
        }
    }

    public int getCheckSum() {
        return checkSum;
    }

    public List<String> getBASKET() {
        return BASKET;
    }

}
