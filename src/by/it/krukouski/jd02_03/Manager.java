package by.it.krukouski.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Manager {

    Manager() {
    }

    static int buyersCount = 0;

    private final AtomicInteger insideCountBuyers = new AtomicInteger(0);
    private final AtomicInteger completeCountBuyers = new AtomicInteger(0);

    public int getCompleteCountBuyers(){
        return completeCountBuyers.get();
    }

    boolean storeClosed() {
        return completeCountBuyers.get() == Config.PLAN_BUYERS;
    }

   boolean storeOpened() {
        return completeCountBuyers.get() + insideCountBuyers.get() < Config.PLAN_BUYERS;
    }

    void addNewBuyer() {
        insideCountBuyers.getAndIncrement();
    }

    void completeBuyer() {
        completeCountBuyers.getAndIncrement();
        insideCountBuyers.getAndDecrement();

    }
}
