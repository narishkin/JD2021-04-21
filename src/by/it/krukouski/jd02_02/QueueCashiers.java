package by.it.krukouski.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueCashiers {
    private QueueCashiers() {
    }

    private static final Object MONITOR_CASHIERS = new Object();

    private static final Deque<Cashier> QUEUE_CASHIERS = new ArrayDeque<>();

    public static int getQueueSize(){
        return QUEUE_CASHIERS.size();
    }

    public static Cashier poll() {
        synchronized (MONITOR_CASHIERS) {
            return QUEUE_CASHIERS.poll();
        }
    }

    public static void add(Cashier cashier) {
        synchronized (MONITOR_CASHIERS) {
            QUEUE_CASHIERS.add(cashier);
        }
    }

    public static int getCashierWorked(){
        return Config.COUNT_CASHIER-getQueueSize();
    }
}
