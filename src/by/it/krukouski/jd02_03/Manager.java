package by.it.krukouski.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Manager {

    Manager() {
    }

    private final AtomicInteger INSIDE_COUNT_BUYERS = new AtomicInteger(0);
    private final AtomicInteger COMPLETE_COUNT_BUYERS = new AtomicInteger(0);

    boolean storeClosed() {
        return COMPLETE_COUNT_BUYERS.get() == Config.PLAN_BUYERS;
    }

    boolean storeOpened() {
        return COMPLETE_COUNT_BUYERS.get() + INSIDE_COUNT_BUYERS.get() < Config.PLAN_BUYERS;
    }

    void addNewBuyer() {
        INSIDE_COUNT_BUYERS.getAndIncrement();
    }

   void completeBuyer() {
        COMPLETE_COUNT_BUYERS.getAndIncrement();
        INSIDE_COUNT_BUYERS.getAndDecrement();

    }
}
