package by.it.sapazhkou.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

   Dispatcher() {
   }
   
   private final AtomicInteger INSIDE_COUNT_BUYERS = new AtomicInteger(0);
   private final AtomicInteger COMPLETE_COUNT_BUYERS = new AtomicInteger(0);
//    static int currentCountBuyer = 0;

//    private static volatile int insideCountBuyers = 0;
//    private static volatile int completeCountBuyers = 0;

//    public static int getInsideCountBuyers() {
//        return insideCountBuyers;
//    }
//
//
    boolean marketClosed() {
        return COMPLETE_COUNT_BUYERS.get() == Configs.PLAN_BUYERS;
    }

    boolean marketOpened() {
        return COMPLETE_COUNT_BUYERS.get() + INSIDE_COUNT_BUYERS.get() < Configs.PLAN_BUYERS;
    }


    void addNewBuyer() {
        INSIDE_COUNT_BUYERS.getAndIncrement();
      }

    void completeBuyer() {
        INSIDE_COUNT_BUYERS.getAndDecrement();
        COMPLETE_COUNT_BUYERS.getAndIncrement();
    }


}
