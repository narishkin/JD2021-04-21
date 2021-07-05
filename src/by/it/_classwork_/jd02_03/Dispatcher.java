package by.it._classwork_.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    Dispatcher() {
    }

    private final AtomicInteger INSIDE_COUNT_BUYERS = new AtomicInteger(0);  //inside
    private final AtomicInteger COMPLETE_COUNT_BUYERS = new AtomicInteger(0); //out

    boolean marketClosed() {
        return COMPLETE_COUNT_BUYERS.get() == Config.PLAN_BUYERS;
    }

    boolean marketOpened() {
        return COMPLETE_COUNT_BUYERS.get() + INSIDE_COUNT_BUYERS.get() < Config.PLAN_BUYERS;
    }

    void addNewBuyer() {
        INSIDE_COUNT_BUYERS.getAndIncrement();
    }

    void completeBuyer() {
        INSIDE_COUNT_BUYERS.getAndDecrement();
        COMPLETE_COUNT_BUYERS.getAndIncrement();
    }


}
