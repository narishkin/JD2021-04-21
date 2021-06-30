package by.it.stain.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers {

    public static final Object MONITOR_QUEUE_BUYERS = new Object();

    private QueueBuyers(){}

    public static final Deque<Buyer>BUYERS = new ArrayDeque<>();

    public static Buyer poll(){
        synchronized (MONITOR_QUEUE_BUYERS){
            return BUYERS.pollFirst();
        }
    }

    public static void add(Buyer buyer){
        synchronized (MONITOR_QUEUE_BUYERS){
            BUYERS.addLast(buyer);
        }
    }
}
