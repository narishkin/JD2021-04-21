package by.it.zhurauleu.jd02_03;

import by.it._classwork_.jd02_02.Config;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    private Dispatcher() {
    }

    private static AtomicInteger insideCountBuyers = new AtomicInteger(0);
    private static AtomicInteger completeCountBuyers = new AtomicInteger(0);

    static boolean marketClosed() {
        return completeCountBuyers.intValue() == Config.PLAN_BUYERS;
    }

    static boolean marketOpened() {
        return completeCountBuyers.intValue() + insideCountBuyers.intValue() < Config.PLAN_BUYERS;
    }



    static synchronized void addNewBuyer() {

        insideCountBuyers.getAndIncrement();
    }

    static synchronized void completeBuyer() {
        insideCountBuyers.getAndDecrement();
        completeCountBuyers.getAndIncrement();
    }

    static int getInsideCountBuyers(){
        return insideCountBuyers.intValue();
    }


}
