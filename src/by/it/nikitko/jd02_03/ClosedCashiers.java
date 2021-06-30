package by.it.nikitko.jd02_03;


import java.util.concurrent.ConcurrentLinkedDeque;

public class ClosedCashiers {


    private static final ConcurrentLinkedDeque<Cashier> closedCushier = new ConcurrentLinkedDeque<>();


    public static Cashier poll() {
            return closedCushier.poll();
    }


    public static void add(Cashier cashier) {
            closedCushier.add(cashier);
    }

    public static int getSize() {
        return closedCushier.size();
    }
    public static boolean isEmpty() {
        return closedCushier.isEmpty();
    }

    public static int getOpenedCashier() {
        return Config.MAX_CASHIER_COUNT-getSize();
    }
}