package by.it.nikitko.jd02_03;


import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    static int peopleCount = 0;
    static int peopleInStore = 0;


    private static final AtomicInteger CUSTOMERS_INSIDE_COUNT = new AtomicInteger(0) ;
    private static final AtomicInteger SERVED_CUSTOMERS_COUNT = new AtomicInteger(0) ;


    public static int getServedCustomersCount() {
        return SERVED_CUSTOMERS_COUNT.get();
    }

    static boolean storeClosed() {
        return SERVED_CUSTOMERS_COUNT.get() == Config.CUSTOMER_PLAN;
    }

    static boolean storeOpened() {
        return SERVED_CUSTOMERS_COUNT.get() + CUSTOMERS_INSIDE_COUNT.get() < Config.CUSTOMER_PLAN;
    }

    static void addCustomer() {
        CUSTOMERS_INSIDE_COUNT.getAndIncrement();
    }

    static  void servedCustomer() {
        CUSTOMERS_INSIDE_COUNT.getAndDecrement();
        SERVED_CUSTOMERS_COUNT.getAndIncrement();
    }
}