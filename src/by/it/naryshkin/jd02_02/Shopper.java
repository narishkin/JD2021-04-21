package by.it.naryshkin.jd02_02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Shopper extends Thread implements TypicalShopper, UsingBasket {
    public final String name;
    private final boolean pensioner;
    private boolean waitPointer;
    public final int numberOfGoods = RandomHelper.random(1, 4);


    private static final Object MONITOR_QUEUE_SHOPPERS = new Object();


    private static final Deque<Shopper> SHOPPERS = new ArrayDeque<>();
    private static final Deque<Shopper> PENSIONERS = new ArrayDeque<>();


    public static Shopper poll() {
        synchronized (MONITOR_QUEUE_SHOPPERS) {
            if (PENSIONERS.size()!=0){
                return PENSIONERS.pollFirst();
            } else {
                return SHOPPERS.pollFirst();
            }
        }
    }

    public static void add(Shopper shopper) {
        synchronized (MONITOR_QUEUE_SHOPPERS) {
            if (shopper.pensioner) {
                PENSIONERS.addLast(shopper);
            } else {
                SHOPPERS.addLast(shopper);
            }
        }
    }

    public static synchronized int getDequeSize() {
        return SHOPPERS.size();
    }


    public void setWaitPointer(boolean waitPointer) {
        this.waitPointer = waitPointer;
    }

    public Shopper(int name, boolean pensioner) {

        this.pensioner = pensioner;
        if (pensioner) {
            this.name = "S-pensioner №" + name;
        } else {
            this.name = "Shopper №" + name;
        }
        Dispatcher.addShopper();
    }

    Object getMonitor() {
        return this;
    }

    @Override
    public void storeEntry() {
//        System.out.println(name + " enters into the store.");
    }

    @Override
    public void takeBasket() {
        if (pensioner) {
            TimerHelper.sleep((RandomHelper.random(500, 2000)) * Config.PENS_COEFFICIENT);
        } else {
            TimerHelper.sleep(RandomHelper.random(500, 2000));
        }
//        System.out.println(name + " takes a basket.");
    }

    @Override
    public void chooseGoods() {
//        System.out.println(name + " is choosing goods.");
        if (pensioner) {
            TimerHelper.sleep((RandomHelper.random(500, 2000) * Config.PENS_COEFFICIENT));
        } else {
            TimerHelper.sleep(RandomHelper.random(500, 2000));
        }
//        System.out.println("Goods were chosen by " + name);
    }


    @Override
    public synchronized void putGoodsToBasket() {
        ArrayList<String> list = new ArrayList<>(Store.GOODS.keySet());
        double puttingTime;
        for (int i = 0; i < numberOfGoods; i++) {
            if (pensioner) {
                puttingTime = RandomHelper.random(500, 2000) * Config.PENS_COEFFICIENT;
            } else {
                puttingTime = RandomHelper.random(500, 2000);
            }
            TimerHelper.sleep(puttingTime);
            int goodNumber = RandomHelper.random(0, list.size() - 1);
//            System.out.println(name + " took " + list.get(goodNumber) + ". It takes: " + puttingTime/1000);
        }
    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            Shopper.add(this);
            try {
                waitPointer = true;
//                while (waitPointer){
                this.wait();
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void storeExit() {
//        System.out.println(name + " goes out.");
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
