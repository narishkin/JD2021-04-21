package by.it.naryshkin.jd02_02;

import java.util.ArrayList;

public class Shopper extends Thread implements TypicalShopper, UsingBasket {
    private final String name;
    private final boolean pensioner;
    private final int numberOfGoods = RandomHelper.random(1, 4);
    private boolean waitPointer;

    public void setWaitPointer(boolean waitPointer) {
        this.waitPointer = waitPointer;
    }

    public Shopper(int name, boolean pensioner) {

        this.pensioner = pensioner;
        if (pensioner) {
            this.name = "Shopper-pensioner №" + name;
        } else {
            this.name = "Shopper № " + name;
        }
        Dispatcher.addShopper();
    }

    Object getMonitor(){
        return this;
    }

    @Override
    public void storeEntry() {
        System.out.println(name + " enters into the store.");
    }

    @Override
    public void takeBasket() {
        if (pensioner) {
            TimerHelper.sleep((RandomHelper.random(500, 2000)) * Config.PENS_COEFFICIENT);
        } else {
            TimerHelper.sleep(RandomHelper.random(500, 2000));
        }
        System.out.println(name + " takes a basket.");
    }

    @Override
    public void chooseGoods() {
        System.out.println(name + " is choosing goods.");
        if (pensioner) {
            TimerHelper.sleep((RandomHelper.random(500, 2000) * Config.PENS_COEFFICIENT));
        } else {
            TimerHelper.sleep(RandomHelper.random(500, 2000));
        }
        System.out.println("Goods were chosen by " + name);
    }


    @Override
    public void putGoodsToBasket() {
        ArrayList<String> list = new ArrayList<>(Store.goods.keySet());
        double puttingTime;
        for (int i = 0; i < numberOfGoods; i++) {
            if (pensioner) {
                puttingTime = RandomHelper.random(500, 2000)*Config.PENS_COEFFICIENT;
            } else {
                puttingTime = RandomHelper.random(500, 2000);
            }
            TimerHelper.sleep(puttingTime);
            int goodNumber = RandomHelper.random(0, list.size() - 1);
            System.out.println(name + " took " + list.get(goodNumber) +
                    " by price " + Store.goods.get(list.get(goodNumber)) +
                    "r. It takes " + puttingTime / 1000 + " seconds.");
        }
        System.out.println(name + " picked " + numberOfGoods + " goods.");

    }

    @Override
    public void goToQueue() {
        synchronized (this){
            QueueShoppers.add(this);
            try {
                waitPointer = true;
                while (waitPointer){
                    this.wait();
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void storeExit() {
        System.out.println(name + " goes out.");
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {

        storeEntry();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        storeExit();
        Dispatcher.finishedShoppersCounter();
    }
}
