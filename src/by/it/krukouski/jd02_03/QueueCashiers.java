package by.it.krukouski.jd02_03;

import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueCashiers {
    private QueueCashiers() {
    }


    private static final ConcurrentLinkedQueue<Cashier> QUEUE_CASHIERS = new ConcurrentLinkedQueue<>();

    public static int getQueueSize() {
        return QUEUE_CASHIERS.size();
    }

    public static Cashier poll() {
        return QUEUE_CASHIERS.poll();

    }

    public static void add(Cashier cashier) {
        QUEUE_CASHIERS.add(cashier);

    }

    public static int getCashierWorked() {
        return Config.COUNT_CASHIER - getQueueSize();
    }
}
