package by.it.nikitko.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {

    private static final Object MONITOR_QUEUE_BUYERS = new Object();

    private QueueBuyers() {
    }

    private static final BlockingDeque<Buyer> BUYERS = new LinkedBlockingDeque<>(30);


    public static Buyer poll() {
        synchronized (MONITOR_QUEUE_BUYERS) {
            return BUYERS.pollFirst();
        }
    }


    public static void add(Buyer buyer) {
        synchronized (MONITOR_QUEUE_BUYERS) {
            try {
                BUYERS.putLast(buyer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
