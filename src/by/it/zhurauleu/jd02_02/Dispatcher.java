package by.it.zhurauleu.jd02_02;

import by.it._classwork_.jd02_02.Config;

class Dispatcher {

    private Dispatcher() {
    }

    private static volatile int insideCountBuyers = 0;
    private static volatile int completeCountBuyers = 0;

    static boolean marketClosed() {
        return completeCountBuyers == Config.PLAN_BUYERS;
    }

    static boolean marketOpened() {
        return completeCountBuyers + insideCountBuyers < Config.PLAN_BUYERS;
    }

    static synchronized void addNewBuyer() {
        insideCountBuyers++;
    }

    static synchronized void completeBuyer() {
        insideCountBuyers--;
        completeCountBuyers++;
    }


}
