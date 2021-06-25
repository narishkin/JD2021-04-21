package by.it.krukouski.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers {

    private QueueBuyers() {
    }

    private static final Object MONITOR_BUYERS = new Object();

    private static final Deque<Buyer> QUEUE_BUYERS = new ArrayDeque<>();

    public static int getQueueSize(){
        return QUEUE_BUYERS.size();
    }

    public static Buyer poll() {
        synchronized (MONITOR_BUYERS) {
            return QUEUE_BUYERS.pollFirst();
        }
    }

    public static void add(Buyer buyer) {
        synchronized (MONITOR_BUYERS) {
            QUEUE_BUYERS.addLast(buyer);
        }
    }

}
