package by.it.krukouski.jd02_02;

class CounterBuyers {

    private CounterBuyers() {
    }

    private static volatile int insideCountBuyers = 0;
    private static volatile int completeCountBuyers = 0;

    static boolean storeClosed() {
        return completeCountBuyers == Config.PLAN_BUYERS;
    }

    static boolean storeOpened() {
        return completeCountBuyers + insideCountBuyers < Config.PLAN_BUYERS;
    }

    static synchronized void addNewBuyer() {
        insideCountBuyers++;
    }

    static synchronized void completeBuyer() {
        completeCountBuyers++;
        insideCountBuyers--;

    }
}
