package by.it.mogonov.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Manager {

    Manager() {
    }

    private final AtomicInteger INSIDE_COUNT_PURCHASERS = new AtomicInteger();
    private final AtomicInteger COMPLETE_COUNT_PURCHASERS = new AtomicInteger();


    boolean koronaClosed() {
        return COMPLETE_COUNT_PURCHASERS.get() >= Conctant.PLAN_PURCHASE;
    }

    boolean koronaOpened() {
        return COMPLETE_COUNT_PURCHASERS.get() < Conctant.PLAN_PURCHASE;
    }

    void addNewPurchaser() {
        INSIDE_COUNT_PURCHASERS.getAndIncrement();
    }

    void complitePurchaser() {
        COMPLETE_COUNT_PURCHASERS.getAndIncrement();

    }

}


