package by.it._classwork_.jd02_02;

class Dispatcher {

    //private static final Object MONITOR = Dispatcher.class;

    private Dispatcher() {
    }

    private static volatile int insideCountBuyers = 0;  //inside
    private static volatile int completeCountBuyers = 0; //out

    static boolean marketClosed() {
        return completeCountBuyers == Config.PLAN_BUYERS;
    }

    static boolean marketOpened() {
        return completeCountBuyers + insideCountBuyers < Config.PLAN_BUYERS;
    }

    static synchronized void addNewBuyer() {
        //synchronized (MONITOR) {
        insideCountBuyers++;
        //}
    }

    static synchronized void completeBuyer() {
        insideCountBuyers--;
        completeCountBuyers++;
    }


}
