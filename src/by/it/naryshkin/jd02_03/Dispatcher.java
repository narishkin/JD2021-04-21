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

    static  void addShopper() {
        currentCountShoppersInside.getAndIncrement();
    }

    static  void finishedShoppersCounter() {
        currentCountShoppersInside.getAndDecrement();
        currentCountShoppersAfterExit.getAndIncrement();
    }

    public static  int getCurrentCashiersNumber() {
        return currentCashiersNumber.get();
    }

    public static  void addCashier() {
        currentCashiersNumber.getAndIncrement();
    }

    public static  void removeCashier() {
        currentCashiersNumber.getAndDecrement();
    }
}
