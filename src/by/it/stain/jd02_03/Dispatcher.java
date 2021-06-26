package by.it.stain.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    Dispatcher() {
    }

    private final AtomicInteger ENTERED_BUYERS = new AtomicInteger(0);
    private final AtomicInteger OUT_BUYERS = new AtomicInteger(0);


    boolean closedSupermarket() {
        return OUT_BUYERS.get() == Configuration.BUYERS;
    }


    boolean openedSupermarket() {
        return ENTERED_BUYERS.get() + OUT_BUYERS.get() < Configuration.BUYERS;
    }

    void buyerAdd() {
        ENTERED_BUYERS.getAndIncrement();
    }

    void buyerComplete() {
        ENTERED_BUYERS.getAndDecrement();
        OUT_BUYERS.getAndIncrement();
    }


}
