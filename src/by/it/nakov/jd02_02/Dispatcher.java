package by.it.nakov.jd02_02;

public class Dispatcher {
    static int currentCountBuyers = 0;
    static int completeCountBuyers = 0;

    private Dispatcher() {
    }

    static boolean storeIsClose() {
        return completeCountBuyers == Config.PLAN_BUYERS;
    }

    static boolean storeIsOpen() {
        return completeCountBuyers + currentCountBuyers < Config.PLAN_BUYERS;
    }

    static synchronized void completeCountBuyers() {
        currentCountBuyers--;
        completeCountBuyers++;
    }

}
