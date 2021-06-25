package by.it.naryshkin.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    static AtomicInteger currentCountShoppersInside = new AtomicInteger(0);
    static AtomicInteger currentCountShoppersAfterExit = new AtomicInteger(0);
    static AtomicInteger currentCashiersNumber = new AtomicInteger(0);


    static boolean storeOpened() {
        return currentCountShoppersAfterExit.get() < Config.PLAN_SHOPPERS;
    }

    static boolean storeClosed() {
        return currentCountShoppersAfterExit.get() + currentCountShoppersInside.get() >= Config.PLAN_SHOPPERS;
    }

    static synchronized void addShopper() {
        currentCountShoppersInside.getAndIncrement();
    }

    static synchronized void finishedShoppersCounter() {
        currentCountShoppersInside.getAndDecrement();
        currentCountShoppersAfterExit.getAndIncrement();
    }

    public static synchronized int getCurrentCashiersNumber() {
        return currentCashiersNumber.get();
    }

    public static synchronized void addCashier(Thread thread) {
        Store.cashierThreads.add(thread);
        currentCashiersNumber.getAndIncrement();
    }

    public static synchronized void removeCashier(Thread thread) {
        Store.cashierThreads.remove(thread);
        currentCashiersNumber.getAndDecrement();
    }
}
