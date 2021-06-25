package by.it.naryshkin.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    AtomicInteger currentCountShoppersInside = new AtomicInteger(0);
    AtomicInteger currentCountShoppersAfterExit = new AtomicInteger(0);
    AtomicInteger currentCashiersNumber = new AtomicInteger(0);

    boolean storeOpened() {
        return currentCountShoppersAfterExit.get() < Config.PLAN_SHOPPERS;
    }

    boolean storeClosed() {
        return currentCountShoppersAfterExit.get() + currentCountShoppersInside.get() >= Config.PLAN_SHOPPERS;
    }

    void addShopper() {
        currentCountShoppersInside.getAndIncrement();
    }

    void finishedShoppersCounter() {
        currentCountShoppersInside.getAndDecrement();
        currentCountShoppersAfterExit.getAndIncrement();
    }

    public int getCurrentCashiersNumber() {
        return currentCashiersNumber.get();
    }

    public void addCashier() {
        currentCashiersNumber.getAndIncrement();
    }

    public void removeCashier() {
        currentCashiersNumber.getAndDecrement();
    }
}
