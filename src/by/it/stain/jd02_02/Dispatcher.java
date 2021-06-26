package by.it.stain.jd02_02;

public class Dispatcher {
    private Dispatcher() {
    }

    private static volatile int enteredBuyers = 0;
    private static volatile int outBuyers = 0;


    static boolean closedSupermarket() {
        return outBuyers == Configuration.BUYERS;
    }


    static boolean openedSupermarket() {
        return enteredBuyers + outBuyers < Configuration.BUYERS;
    }



    static synchronized void buyerAdd() {
        enteredBuyers++;
    }

    static synchronized void buyerComplete() {
        enteredBuyers--;
        outBuyers++;
    }


}
