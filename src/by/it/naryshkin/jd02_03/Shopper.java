package by.it.naryshkin.jd02_03;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;

public class Shopper extends Thread implements TypicalShopper, UsingBasket {
    public final String name;
    private final boolean pensioner;
    private boolean waitPointer;
    public final int numberOfGoods = RandomHelper.random(1, 4);
    public short basketNumber;
    private final Dispatcher dispatcher;
    static final Semaphore semaphore = new Semaphore(20);
    private static final BlockingDeque<Shopper> SHOPPERS = new LinkedBlockingDeque<>(Config.QUEUE_CAPACITY);
    private static final BlockingDeque<Shopper> PENSIONERS = new LinkedBlockingDeque<>(Config.QUEUE_CAPACITY);


    public Shopper(int name, boolean pensioner, Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.pensioner = pensioner;
        if (pensioner) {
            this.name = "S-pensioner №" + name;
        } else {
            this.name = "Shopper №" + name;
        }
        dispatcher.addShopper();
    }

    public static Shopper poll() {
        if (PENSIONERS.size() != 0) {
            return PENSIONERS.pollFirst();
        } else {
            return SHOPPERS.pollFirst();
        }
    }

    public void add(Shopper shopper) {
        if (shopper.pensioner) {
            try {
                PENSIONERS.putLast(shopper);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                SHOPPERS.putLast(shopper);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getDequeSize() {
        return SHOPPERS.size() + PENSIONERS.size();
    }


    public void setWaitPointer(boolean waitPointer) {
        this.waitPointer = waitPointer;
    }

    Object getMonitor() {
        return this;
    }

    // Shopper's store way

    @Override
    public void storeEntry() {
//        System.out.println(name + " enters into the store.");
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void takeBasket() {
        try {
            basketNumber = Basket.basketBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        }
    }

    @Override
    public void goToQueue() {
        semaphore.release();
        synchronized (this) {
            add(this);
            try {
                waitPointer = true;
                while (waitPointer) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void storeExit() {
        try {
            Basket.basketBlockingQueue.put(this.basketNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        dispatcher.finishedShoppersCounter();
    }
}
