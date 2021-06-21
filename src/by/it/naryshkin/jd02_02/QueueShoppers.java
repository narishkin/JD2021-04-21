package by.it.naryshkin.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueShoppers {
    private static final Object MONITOR_QUEUE_SHOPPERS = new Object();

    private QueueShoppers(){
    }

    private static final Deque<Shopper> SHOPPERS = new ArrayDeque<>();


    public static Shopper poll() {
        synchronized (MONITOR_QUEUE_SHOPPERS) {
            return SHOPPERS.pollFirst();
        }


    }
    public static void add(Shopper shopper){
        synchronized (MONITOR_QUEUE_SHOPPERS){
            SHOPPERS.addLast(shopper);
        }
    }

}
