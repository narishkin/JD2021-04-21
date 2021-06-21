package by.it.nikitko.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class ClosedCashiers {
    public static final Object MONITOR_CLOSED_CASHEIRS = new Object();

    private static Deque<Cashier> closedCushier = new ArrayDeque<>();

    public static Cashier poll() {
        synchronized (MONITOR_CLOSED_CASHEIRS) {
            return closedCushier.poll();
        }
    }

    public static int getSize() {
        return closedCushier.size();
    }



    public static void add(Cashier cashier) {
        synchronized (MONITOR_CLOSED_CASHEIRS) {
            closedCushier.add(cashier);
        }
    }
}