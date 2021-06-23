package by.it.nikitko.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class ClosedCashiers {
    public static final Object MONITOR_CLOSED_CASHIERS = new Object();

    private static final Deque<Cashier> closedCushier = new ArrayDeque<>();



    public static int getOpenedCashier() {
        return Config.MAX_CASHIER_COUNT-getSize();
    }

    public static Cashier poll() {
        synchronized (MONITOR_CLOSED_CASHIERS) {
            return closedCushier.poll();
        }
    }

    public static int getSize() {
        return closedCushier.size();
    }



    public static void add(Cashier cashier) {
        synchronized (MONITOR_CLOSED_CASHIERS) {
            closedCushier.add(cashier);
        }
    }
}